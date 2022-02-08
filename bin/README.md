## Requisitos
Crear formulario de registro de usuarios con los siguientes campos:
- Nombre
- Apellidos
- Teléfono
- Email
- Fecha de nacimiento
- Contraseña
- Validación de contraseña


El formulario tendrá que estar ubicado en el template ya creado "form-page.html" cuyo recurso se carga desde el HomeController. Se deberá gestionar la recepción del contenido del formulario desde el mismo controlador, o desde otro nuevo, para una vez recogido los datos sean mostrados en otra nueva página.

Se podrá usar cualquier librería externa que no esté incluida en el proyecto.

## No será obligatorio pero se valorará de manera positiva
- Tymeleaf como motor de plantillas https://www.thymeleaf.org/
- Uso de JQuery validation https://jqueryvalidation.org/
- Uso de TDD

## Instalación
Clonar repositorio

```sh
git clone https://github.com/belive-globalia/prueba-formulario.git
```

Para ejecutar el proyecto:

```sh
mvn spring-boot:run
```

## Entrega
La prueba se podrá entregar con un enlace a un repositorio público o comprimiendo el proyecto incluyendo el .git.
