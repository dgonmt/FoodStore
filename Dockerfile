FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_USER: admin
ENV MYSQL_PASSWORD: password

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 3309