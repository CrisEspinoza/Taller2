# Taller1

GRUPO 7 - INTEGRANTES: 
- Veronica Calas
- Cristobal Donoso
- Maximiliano Espinosa
- Cristian Espinoza
- Jesus Mura
- Sebastian Pinto	

Tenemos que este taller contiene dos carpetas por un lado tenemos que contiene Taller1-TBD y por el
otro lado tenemos a Taller1-TBD-Front

- En primer lugar la carpeta Taller1-TBD:
	* Esta carpeta se encarga de contener el backend de la aplicación.
	* Para poder ejecutarla basta con colocar el comando "gradle bootrun"
	* Ahora si desea verifcar los servicios por serapado del front-end, basta con colocar
	estas url en el Postman:
			
		- http://localhost:8081/actors -> El cual nos indica la cantidad de actores totales
				que contiene nuestra base de datos (Tener en cuenta que la base
				de datos al comienzo de la aplicación esta vacia)
		- http://localhost:8081/actors/"x" -> Esta url nos indica poder seleccionar a un 
				actor segun su 'id', la cual se coloca el numero de la id del 
				actor que desea buscar en la parte de la "x". Ejemplo: Para 
				bucar el actor 1 tenemos que es la siguiente url: 					http://	localhost:8081/actors/1.
		- http://localhost:8081/actors/create -> Con esta url tenemos que se crea un nuevo
				actor al momento de entregarle un Json con la información del actor
				nuevo la cual seria su primer nombre y su primer apeliido.
- Por ultimo, tenemos la carpeta Taller1-TBD-Front:
	* En esta carpeta tenemos localizado el front-end del taller 1.
	* Para poder ejecutar esta aplicación tenemos que seguir esta secuencia de pasos:
		1. Entrar a la carpeta plantilla-vue
		2. Instalar las dependencias con el siguiente comando: npm install
		3. Ejecutar la aplicación con el comando: npm run dev.


											 
