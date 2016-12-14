ClienteFTP
======================



  
  - [__Introducción__](#introducción)
  - [__FTP__](#ftp)
  - [__Objetivo__](#objetivo)
  - [__Uso__](#uso)
  
 


#### Introducción 

Voy a usar la API de sockets de Java para implementar mi propio cliente FTP. Mi
cliente FTP se conectará a un servidor FTP que permita usuarios anónimos (FTP anónimos).
Existen muchos servidores anónimos disponibles en Internet. Podemos elegir cualquiera de
ellos para realizar nuestro cliente FTP.
La siguiente URL nos muestra un listado de servidores
de FTP: http://www.ftp-sites.org/
Por ejemplo, podemos usar el siguiente:
speedtest.tele2.net


#### FTP 

En primer lugar, tendremos que abrir un socket cliente con el servidor FTP
(speedtest.tele2.net) en el puerto de control FTP, esto es, el puerto 21. Una vez hecho
esto, tendrás que implementar el protocolo FTP, enviando los mensajes oportunos desde el
cliente al servidor. En concreto, se pide que se manden los siguientes mensajes desde el
cliente FTP:


![alt tag](https://github.com/carlos-camara/ClienteFTP/blob/master/mensajeftp.png)

El servidor irá respondiendo con los mensajes definidos en el protocolo FTP. Esto mensajes se
muestran con flechas rojas en el siguiente diagrama. Habrá que recibir estas respuestas desde
nuestra implementación en Java. Podemos ir mostrando estas respuestas en la salida estándar
para trazar nuestro programa:

![alt tag](https://github.com/carlos-camara/ClienteFTP/blob/master/mensajeftp2.png)


#### Objetivo 

En esta práctica se pide mandar ciertos mensajes FTP desde cliente al servidor. Estos mensajes
son los que están pintados con flechas azules en los diagramas anteriores.
El objetivo final de la práctica es conectarse al servidor usando FTP pasivo. Recuerda que en el
intercambio datos en FTP se usa un puerto diferente al 21 para los datos. En FTP pasivo, este
puerto se obtiene como respuesta al comando PASV. A nivel de Java, necesitarás abrir un
**segundo socket al puerto de datos**.
Una vez establecido el modo pasivo de FTP, ejecutaremos el comando LIST en usando la
conexión de control (puerto 21) para obtener la lista de ficheros disponibles en el servidor.
Mostraremos esta lista por la salida estándar.
Un ejemplo de la secuencia de mensajes y respuestas completa que se pide en la práctica es
como sigue:

![alt tag](https://github.com/carlos-camara/ClienteFTP/blob/master/fotoftp3.png)

#### Uso 
Clonar el repositorio ClienteFTP
 >$ git clone https://github.com/carlos-camara/ClienteFTP.git
