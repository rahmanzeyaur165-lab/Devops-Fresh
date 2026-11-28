# Ansible Linux Server Automation

## 1. Project Overview

This project automates the configuration of Linux servers using Ansible.

The assignment objective is to automate the following operations across 50 Linux servers:

- Install Java 21.
- Install required packages.
- Create application directories.
- Configure application environment variables.
- Configure and restart application services.
- Verify service status.
- Execute changes in batches of 10 servers.
- Stop further deployment batches when a fatal error occurs.

## 2. Architecture

Ansible Control Node (Ubuntu WSL)
          |
          | SSH
          v
    Managed Linux Servers
          |
          v
 Java + Packages + Directories
          |
          v
 Environment Configuration
          |
          v
 Service Restart and Verification

## 3. Project Structure

ansible-server-automation/
|
|-- inventory/
|   |-- hosts.ini
|
|-- playbooks/
|   |-- server_setup.yml
|   |-- service_setup.yml
|
|-- README.md

## 4. Technologies Used

- Ubuntu 24.04
- Ansible 13.1.0
- Ansible Core 2.20.1
- Python
- OpenSSH
- Docker Desktop
- Supervisor
- OpenJDK 21

## 5. Server Configuration

The current practice environment contains one managed Ubuntu Linux container.

Connection details:

- Managed host: server1
- SSH host: 127.0.0.1
- SSH port: 2222
- SSH user: ansible
- Authentication: SSH key

For the actual 50-server environment, add the real hostnames or IP addresses and SSH access details to inventory/hosts.ini.

## 6. Inventory Configuration

The inventory uses a linux_servers group.

Example for actual infrastructure:

[linux_servers]
server1 ansible_host=SERVER1_IP
server2 ansible_host=SERVER2_IP
server3 ansible_host=SERVER3_IP

[linux_servers:vars]
ansible_user=ansible
ansible_python_interpreter=/usr/bin/python3

Replace the placeholders with real server addresses and configure SSH access.

## 7. Automation Playbooks

### server_setup.yml

Automates:

- Java 21 installation
- curl, Git and unzip installation
- Application directory creation
- Environment variable configuration

### service_setup.yml

Automates:

- Supervisor installation
- Supervisor daemon startup
- Application service configuration
- Supervisor configuration reload
- Service restart
- Service status verification

## 8. Batch Execution and Error Handling

Both playbooks use:

serial: 10
any_errors_fatal: true

This processes up to 10 servers in each batch and stops further batches when a fatal task error occurs.

For 50 servers, the intended execution is five batches of 10 servers.

## 9. Execution Commands

Check connectivity:

ansible linux_servers -i inventory/hosts.ini -m ping

Check server setup syntax:

ansible-playbook -i inventory/hosts.ini playbooks/server_setup.yml --syntax-check

Run server setup:

ansible-playbook -i inventory/hosts.ini playbooks/server_setup.yml

Check service setup syntax:

ansible-playbook -i inventory/hosts.ini playbooks/service_setup.yml --syntax-check

Run service setup:

ansible-playbook -i inventory/hosts.ini playbooks/service_setup.yml

Verify Java:

ansible linux_servers -i inventory/hosts.ini -b -m command -a "java -version"

Verify directories:

ansible linux_servers -i inventory/hosts.ini -b -m command -a "ls -ld /opt/incident-management /var/log/incident-management"

Verify environment variables:

ansible linux_servers -i inventory/hosts.ini -b -m shell -a ". /etc/profile.d/incident-management.sh && echo APP_ENV=\$APP_ENV"

Verify service:

ansible linux_servers -i inventory/hosts.ini -b -m command -a "supervisorctl status incident-management"

## 10. Verification Results

Practice server verification:

- Ansible connectivity: Successful
- Java 21 installation: Successful
- Required packages: Successful
- Application directories: Created
- Environment variables: Configured
- Supervisor service: RUNNING
- Service verification: Successful
- Playbook failures: 0

## 11. Production Considerations

The current environment is a practice lab with one Docker-based Linux container.

The Supervisor-managed process is a placeholder, not the actual Spring Boot application.

For production deployment:

- Use actual server IP addresses or DNS names.
- Use secured SSH credentials.
- Store secrets with Ansible Vault.
- Follow least-privilege sudo access.
- Use systemd for services on systemd-based Linux servers.
- Configure monitoring, logging and backups.
- Test changes on a small group before wider rollout.

## 12. Conclusion

The Ansible automation workflow has been implemented and tested successfully on one practice Linux server.

The inventory and batch execution configuration are prepared to support a 50-server environment once the real managed servers and SSH access are available.
