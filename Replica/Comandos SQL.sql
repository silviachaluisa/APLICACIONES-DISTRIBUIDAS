-- Verificar el estado del maestro
SHOW MASTER STATUS;

-- Verificar el estado de la replicación
SHOW SLAVE STATUS;
-- Cambiar el master host, user, password, log file y log pos
CHANGE MASTER TO MASTER_HOST='', MASTER_USER='',MASTER_PASSWORD='',--Este es para configurar el esclavo

CHANGE MASTER TO MASTER_LOG_FILE='mysql-bin.000003', MASTER_LOG_POS=477;


-- Iniciar la replicación
START SLAVE;

--Creación de usuarios para otorgar permisos
CREATE USER 'repl_user'@'%' IDENTIFIED BY 'repl_password';
GRANT REPLICATION SLAVE ON *.* TO 'repl_user'@'%';
FLUSH PRIVILEGES;

--Configurar nodo maestro 1
CHANGE MASTER TO
    MASTER_HOST='mysql-master-2',
    MASTER_USER='repl_user',
    MASTER_PASSWORD='repl_password',
    MASTER_LOG_FILE='[File_de_master2]',
    MASTER_LOG_POS=[Position_de_master2];
START SLAVE;

--Configurar nodo maestro 2
CHANGE MASTER TO
    MASTER_HOST='mysql-master-1',
    MASTER_USER='repl_user',
    MASTER_PASSWORD='repl_password',
    MASTER_LOG_FILE='[File_de_master1]',
    MASTER_LOG_POS=[Position_de_master1];
START SLAVE;
