# Crear una imagen de Docker con un servidor web en Python
FROM python:latest
#Establecer el directorio de trabajo
WORKDIR /Servidor1

# Copiar los archivos al contenedor
COPY servidor1.py .

# Ejecutar comandos (instalar dependencias, en este caso Flask)
RUN pip install Flask

# Exponer el puerto 5000
EXPOSE 5000

# Ejecutar el servidor
CMD ["python", "servidor1.py"]