# Crear una imagen de Docker con un servidor web en Python
FROM python:3.11


# Copiar los archivos al contenedor
COPY mapReduce.py /app/mapReduce.py

#Establecer el directorio de trabajo
WORKDIR /app

# Ejecutar comandos (instalar dependencias, en este caso Flask)
RUN pip install mrjob

