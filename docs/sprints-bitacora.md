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

# Sprint 2 – Bitácora (Modelo)

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

---

## 4.2 User Stories implementadas

### #30 Reservas: Seleccionar fecha

Esta historia de usuario fue resuelta de forma anticipada durante los Sprints 2 y 3, como resultado de la implementación progresiva de funcionalidades relacionadas:

- **Sprint 2:** Se implementó el sistema de autenticación (registro, login, cierre de sesión) y el control de roles, estableciendo la base necesaria para validar si un usuario está logueado al momento de reservar.
- **Sprint 3:** Se implementaron la búsqueda con calendario doble, la visualización de disponibilidad de fechas y el sistema de reservas desde el detalle del producto, incluyendo el calendario interactivo con selección de rango de fechas.

Todos los criterios de aceptación de la historia #30 se encuentran cubiertos por la implementación existente:

| Criterio de aceptación | Componente / Funcionalidad |
| --- | --- |
| Acceder a reservas desde detalle del producto | `ProductDetail.tsx` – Botón "Reservar ahora" y calendario de disponibilidad para productos tipo RESERVA |
| Verificar si el usuario está logueado al reservar | `ProductDetail.tsx` – Validación de autenticación previa a la reserva |
| Redirigir a página de reserva si está logueado | Flujo de reserva integrado en el detalle del producto |
| Redirigir a login si no está registrado | `AuthPromptModal.tsx` – Modal con redirección a `/acceso` |
| Texto indicando que el login es obligatorio | `AuthPromptModal.tsx` – "Para comprar o reservar, primero inicia sesión" |
| Buscar productos disponibles por fecha | `Home.tsx` – Modo "RESERVAS" con filtros `dateFrom` y `dateTo` |
| Mostrar lista de productos que coinciden con la fecha | Servicio de productos con filtrado por tipo y rango de fechas |
| Seleccionar rango de fechas para la reserva | `AvailabilityCalendar.tsx` – Calendario doble con selección de rango |
| Imprimir rango seleccionado en el formulario | Fechas seleccionadas reflejadas en el formulario de reserva |
| No incluir fechas no disponibles en el rango | Validación de superposición con fechas ocupadas en el calendario |

---

## 4.3 Licencias de diseño y decisiones de implementación

- **Resolución anticipada de la historia #30:**  
  La historia de usuario #30 fue implementada de forma orgánica durante los sprints anteriores. La decisión de incluir el sistema de reservas como parte del flujo de productos (Sprint 3) y el sistema de autenticación (Sprint 2) hizo que todos los criterios de aceptación quedaran cubiertos sin necesidad de desarrollo adicional en el Sprint 4.

---