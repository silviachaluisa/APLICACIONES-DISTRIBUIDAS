# Crear una imagen de Docker con un servidor web en Python
FROM python:latest

#Establecer el directorio de trabajo en la carpeta de la aplicación
WORKDIR /servidor2

# Copiar los archivos al contenedor
COPY app1.py .

# Ejecutar comandos (instalar dependencias, en este caso Flask)
RUN pip install Flask

# Exponer el puerto 5000
EXPOSE 5003

# Ejecutar el servidor
CMD ["python", "app1.py"]