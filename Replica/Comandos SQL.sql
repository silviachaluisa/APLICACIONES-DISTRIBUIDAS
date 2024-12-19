-- Verificar el estado del maestro
SHOW MASTER STATUS;

-- Cambiar el master host, user, password, log file y log pos
CHANGE MASTER TO MASTER_HOST='', MASTER_USER='',MASTER_PASSWORD='',--Este es para configurar el esclavo

CHANGE MASTER TO MASTER_LOG_FILE='mysql-bin.000003', MASTER_LOG_POS=477;


--MAESTRO-MAESTRO

--Configurar nodo maestro 2
CHANGE MASTER TO
  MASTER_HOST = 'mysql-master1',
  MASTER_USER = 'root',
  MASTER_PASSWORD = 'root',
  MASTER_LOG_FILE = 'mysql-bin.000001', coloca lo que te salga en tu php
  MASTER_LOG_POS = 154;  -- Usa tu posicion

-- Iniciar la replicación
START SLAVE;
-- Verificar el estado de la replicación
SHOW SLAVE STATUS;