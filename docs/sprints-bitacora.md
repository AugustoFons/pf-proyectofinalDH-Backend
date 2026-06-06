# Sprint 1 – Bitácora

## 1.1 Definición del proyecto

**marketplease!** es una aplicación web orientada a la publicación, visualización y gestión de productos, con un enfoque tanto en la compra/venta como en la reserva de los mismos.  
El objetivo principal es permitir a los usuarios explorar productos de manera simple e intuitiva, mientras que los administradores pueden gestionar el catálogo mediante funcionalidades dedicadas (Publicar, Editar y Eliminar).

El proyecto está desarrollado con:
- **Frontend:** React
- **Backend:** Java Spring Boot
- **Base de datos:** MySQL

---

## 1.2 Objetivo del Sprint 1

El objetivo del Sprint 1 fue construir la **estructura base de la aplicación**, implementando las funcionalidades principales de:
- Registro de productos
- Visualización de productos
- Eliminación de productos
- Navegación básica del sitio, tanto en su versión pública como en el acceso administrativo (mock).
- Funcionalidad de administración inicial

---

## 1.3 User Stories implementadas

Durante el Sprint 1 se implementaron las siguientes historias de usuario:

- #1 Colocar encabezado
- #2 Definir el cuerpo del sitio
- #3 Registrar producto
- #4 Visualizar productos en el home
- #5 Visualizar detalle de producto
- #6 Visualizar galería de imágenes
- #7 Colocar pie de página
- #8 Paginar productos
- #9 Panel de administración
- #10 Listar productos
- #11 Eliminar producto

Todas las historias planificadas para el sprint fueron implementadas y testeadas correctamente.

---

## 1.4 Licencias de diseño y adaptaciones

Durante el desarrollo se tomaron algunas decisiones que implicaron adaptaciones respecto a los criterios originales:

- **Footer:**  
  Por un criterio visual se optó por una disposición centrada del footer, colocando el logotipo en el centro y el copyright debajo del mismo.

- **Galería de imágenes:**  
  Se optó por una disposición alternativa a la propuesta en los criterios de aceptación, cumpliendo el objetivo principal: permitir al usuario visualizar claramente las imágenes del producto.

- **Panel de administración y Listado de productos:**  
  Si bien el criterio de aceptación menciona la existencia de un menú con las funciones de administración, en este Sprint se decidió no implementar un menú independiente, dado que la única funcionalidad administrativa desarrollada corresponde a la gestión de productos.

  En su lugar, se optó por un enfoque basado en acciones, donde las opciones de edición y eliminación se encuentran directamente asociadas a las cards de cada producto. Esta decisión mejora la usabilidad y evita una navegación innecesaria.

  La incorporación de un menú administrativo queda contemplada para sprints posteriores, en caso de que se desarrollen múltiples funcionalidades que justifiquen su implementación.

  El acceso a la lista de productos se realiza directamente al ingresar al panel de administración, funcionando como vista principal. Por este motivo, no se incluyó un botón adicional “Lista de productos”, ya que la funcionalidad solicitada se encuentra disponible de forma inmediata.

---

# Sprint 2 – Bitácora

## 2.1 Objetivo del Sprint 2

El objetivo del Sprint 2 fue ampliar las funcionalidades de la plataforma incorporando **gestión de usuarios, autenticación y categorización de productos**, permitiendo mejorar la organización del catálogo y habilitar funcionalidades personalizadas para usuarios registrados.

Durante este sprint se trabajó principalmente en:
- Registro de usuarios
- Inicio y cierre de sesión
- Gestión de roles de administrador
- Categorías de productos
- Características de productos
- Visualización de características en el detalle de producto

---

## 2.2 User Stories implementadas

Durante el Sprint 2 se planificaron e implementaron las siguientes historias de usuario:

- #12 Categorizar productos
- #13 Registrar usuario
- #14 Identificar usuario (login)
- #15 Cerrar sesión
- #16 Identificar administrador
- #17 Administrar características de producto
- #18 Visualizar características del producto
- #20 Crear sección de categorías
- #21 Agregar categoría

*(Opcional)*  
- #19 Notificación de confirmación de registro por correo electrónico

---

## 2.3 Licencias de diseño y decisiones de implementación

Durante el desarrollo del Sprint 2 se tomaron algunas decisiones técnicas y de diseño para mejorar la experiencia de usuario y la mantenibilidad del sistema.

- **Identificar usuario:**  
  El usuario puede accerder a su información personal una vez iniciada la sesión, dirijiendose al avatar del Header donde se abrira un dropdown para llegar a esta sección.

- **Administrar características:**  
  Las caracteristicas se pueden asociar al crear o al editar un producto siendo un administrador. El nombre de la característica es "libre" y se puede asociar a iconos predefinidos que se ponen a disposición.

- **Notificación: Confirmación de registro de usuario:**  
  Se decidió por el momento no implementar el desafio opcional, y evaluarlo en el sprint 4 en el que se piden implementaciones de envios de emails.

- **Características de producto:**  
  Se optó por implementar las características como entidades reutilizables que pueden asociarse a múltiples productos, facilitando su mantenimiento desde el panel administrativo.

---

# Sprint 3 – Bitácora

## 3.1 Objetivo del Sprint 3

El objetivo del Sprint 3 fue incorporar funcionalidades de **búsqueda, disponibilidad, favoritos, políticas de producto, compartir en redes, puntuaciones y gestión de categorías**, mejorando la experiencia del usuario y ampliando las capacidades interactivas de la plataforma.

Durante este sprint se trabajó principalmente en:
- Búsqueda de productos con autocompletar y calendario
- Visualización de disponibilidad de fechas
- Sistema de favoritos para usuarios autenticados
- Bloque de políticas del producto
- Compartir productos en redes sociales
- Puntuación y reseñas de productos
- Eliminación de categorías desde administración

---

## 3.2 User Stories implementadas

Durante el Sprint 3 se planificaron e implementaron las siguientes historias de usuario:

- #22 Realizar búsqueda
- #23 Visualizar disponibilidad
- #24 Marcar como favorito
- #25 Listar productos favoritos
- #26 Ver bloque de políticas del producto
- #27 Redes: Compartir productos
- #28 Puntuar producto
- #29 Eliminar categoría

---

## 3.3 Licencias de diseño y decisiones de implementación

- **Adaptación del sistema de compras y reservas:**  
  Al haberse incluido en el sistema inicialmente un sistema de compras, además del requerido de reservas, se adapto para que tenga un comportamiento similar en cuantos al sistema de puntuación y reseñas. Una vez que el usuario selecciona "Comprar", queda habilitado para puntuar y reseñar. Adicionalmente se agrego el menú "Actividad", donde el usuario puede consultar sus compras y reservas. 

---

# Sprint 4 – Bitácora

## 4.1 Objetivo del Sprint 4

El objetivo del Sprint 4 es consolidar el **flujo completo de reservas**, incorporando la selección de fechas, la confirmación de la reserva y las comunicaciones asociadas al proceso.

Durante este sprint se trabaja principalmente en:
- Selección de fechas para reservas
- Confirmación y gestión de reservas
- Comunicaciones por correo electrónico relacionadas con reservas
- Comunicación con el proveedor a través de WhatsApp

---

## 4.2 User Stories implementadas
Durante el Sprint 3 se planificaron e implementaron las siguientes historias de usuario:

- #30 Reservas: Seleccionar fecha
- #31 Reservas: Visualizar detalles
- #32 Realizar reserva
- #33 Acceder a historial
- #34 WhatsApp: Iniciar chat
- #35 Notificación: Confirmar reserva/compra por correo


---

## 4.3 Licencias de diseño y decisiones de implementación

- **Resolución anticipada de la historia #30:**  
  La historia de usuario #30 fue implementada de forma indirecta durante los sprints anteriores. La decisión de incluir el sistema de reservas como parte del flujo de productos (Sprint 3) y el sistema de autenticación (Sprint 2) hizo que todos los criterios de aceptación quedaran cubiertos sin necesidad de desarrollo adicional en el Sprint 4.

- **Confirmación de la reserva mediante modal en lugar de página dedicada (#31):**  
  Si bien la historia de usuario menciona una "página de reservas", se optó por implementar la confirmación como un **modal** sobre el detalle del producto. Esto permite mantener el contexto visual con todos los detalles del producto y evita una navegación adicional. Los cuatro criterios de aceptación se cumplen igualmente dentro del modal.

- **Realizar reserva/compra (#32):**  
  Esta historia tambien la considera parcialmente completa por decisiones anteriores, considere darle más detalle al modal de confirmación para que tras la confirmación se genere un **comprobante tipo ticket** descargable con todo el detalle de la operación. Con esto se incorporan dos acciones: **"Descargar comprobante"**, que genera un documento imprimible en una ventana aparte (permite *Guardar como PDF*), e **"Ir a mi actividad"**, que navega a `/actividad`.

- **Resolución anticipada de la historia #33:**  
  El historial de reservas quedó cubierto por la sección **"Mi Actividad"** implementada como una licensa de diseño en el Sprint 3, que ya lista las reservas del usuario ordenadas por fecha y con la información relevante de cada una (producto, periodo de uso, fecha de registro y estado). Por este motivo no se requirió desarrollo adicional en el Sprint 4.

- **Comunicación por WhatsApp (#34):**  
  El número de WhatsApp se almacena en la tabla de roles en el rol `ROLE_ADMIN`, por defecto se carga mi número personal. Dado que el enlace oficial `wa.me` no permite a la web confirmar si el mensaje fue efectivamente enviado, se muestra una notificación al iniciar el chat y una confirmación adicional al regresar a la aplicación. 

- **Notificación por correo (#35):**  
  Tras confirmar una compra o reserva, el modal de éxito informa al usuario que en unos minutos recibirá un correo con el resumen de la operación en su dirección registrada. Al igual que con el numero de telefono se decidio manejar el caso con un solo email encargado del envío. En este caso el email se configura en el backend (application.properties o .env)

---