# Plan de testing – Sprint 1

Se realizaron pruebas funcionales manuales desde la interfaz de usuario, validando los criterios de aceptación definidos para cada historia de usuario del Sprint 1.

| User Story            | Caso de prueba                                  | Resultado esperado                            | Resultado obtenido |
| --------------------- | ----------------------------------------------- | --------------------------------------------- | ------------------ |
| #1 Header             | Visualizar encabezado fijo en todas las páginas | El header permanece visible al hacer scroll   | OK                 |
| #2 Main               | Verificar color de fondo y estructura           | El main respeta la identidad visual           | OK                 |
| #3 Registrar producto | Crear un producto con datos válidos             | Producto creado y almacenado                  | OK                 |
| #4 Home               | Visualizar productos aleatorios                 | Se muestran hasta 10 productos sin repetición | OK                 |
| #5 Detalle            | Acceder al detalle de un producto               | Se visualiza información completa             | OK                 |
| #6 Galería            | Visualizar galería de imágenes                  | Imágenes se muestran correctamente            | OK                 |
| #9 Administración     | Acceder a /administracion                       | Se visualiza el panel de administración       | OK                 |
| #10 Listado           | Ver listado de productos                        | Se listan ID, nombre y acciones               | OK                 |
| #11 Eliminar          | Eliminar un producto                            | El producto se elimina del sistema            | OK                 |

Todos los casos de prueba definidos para el Sprint 1 fueron ejecutados exitosamente.

---

# Plan de testing – Sprint 2

Se realizaron pruebas funcionales manuales desde la interfaz de usuario, validando los criterios de aceptación definidos para cada historia de usuario del Sprint 2.

| User Story                     | Caso de prueba                                 | Resultado esperado                                          | Resultado obtenido |
| ------------------------------ | ---------------------------------------------- | ----------------------------------------------------------- | ------------------ |
| #12 Categorizar productos      | Asignar una categoría a un producto existente  | El producto queda asociado a la categoría seleccionada      | OK                 |
| #13 Registrar usuario          | Registrar un usuario con datos válidos         | El usuario se registra correctamente en el sistema          | OK                 |
| #13 Registrar usuario          | Registrar usuario con datos inválidos          | El sistema muestra mensajes de validación                   | OK                 |
| #14 Login                      | Iniciar sesión con credenciales válidas        | El usuario accede al sistema correctamente                  | OK                 |
| #14 Login                      | Iniciar sesión con credenciales incorrectas    | Se muestra mensaje de error                                 | OK                 |
| #15 Cerrar sesión              | Hacer clic en “Cerrar sesión” desde el avatar  | La sesión se cierra y el usuario vuelve a modo anónimo      | OK                 |
| #16 Rol administrador          | Asignar permisos de administrador a un usuario | El usuario obtiene acceso a funcionalidades administrativas | OK                 |
| #17 Características            | Crearle una característica a un producto       | La característica se asocia correctamente                   | OK                 |
| #17 Características            | Editar una característica existente            | Los cambios se guardan correctamente                        | OK                 |
| #17 Características            | Eliminar una característica                    | La característica se elimina                                | OK                 |
| #18 Visualizar características | Ver características en el detalle de producto  | Se muestran ícono y nombre de cada característica           | OK                 |
| #20 Filtrar por categorías     | Seleccionar una categoría en el filtro         | Se muestran solo productos de esa categoría                 | OK                 |
| #20 Filtrar por categorías     | Limpiar filtros                                | Se vuelve a mostrar el listado completo de productos        | OK                 |
| #21 Agregar categoría          | Crear una nueva categoría desde administración | La categoría se guarda y aparece disponible                 | OK                 |

Todos los casos de prueba definidos para el Sprint 2 fueron ejecutados exitosamente.

---

# Plan de testing – Sprint 3

Se realizaron pruebas funcionales manuales desde la interfaz de usuario, validando los criterios de aceptación definidos para cada historia de usuario del Sprint 3.

| User Story                     | Caso de prueba                                          | Resultado esperado                                                   | Resultado obtenido |
| ------------------------------ | ------------------------------------------------------- | -------------------------------------------------------------------- | ------------------ |
| #22 Realizar búsqueda          | Ingresar criterios de búsqueda y ejecutarla             | Se muestran resultados relevantes y precisos según los criterios     | OK                 |
| #22 Realizar búsqueda          | Ingresar texto en el campo de búsqueda                  | Se ofrecen sugerencias y autocompletar de palabras clave relevantes  | OK                 |
| #22 Realizar búsqueda          | Seleccionar un rango de fechas con el calendario doble  | El calendario doble permite seleccionar correctamente fecha inicio y fin | OK                 |
| #23 Visualizar disponibilidad | Acceder al detalle de un producto y ver calendario doble| El calendario doble destaca las fechas disponibles correctamente     | OK                 |
| #23 Visualizar disponibilidad | Verificar indicador visual de fechas ocupadas            | Las fechas ocupadas se muestran en un color diferente o con indicador | OK                 |
| #24 Marcar como favorito      | Hacer clic en el ícono de favorito de un producto       | El producto se marca como favorito                                   | OK                 |
| #24 Marcar como favorito      | Desmarcar un producto como favorito                     | El producto se elimina de favoritos correctamente                    | OK                 |
| #25 Listar productos favoritos | Acceder a la lista de favoritos desde la cuenta de usuario | Se muestran los productos marcados como favoritos previamente       | OK                 |
| #25 Listar productos favoritos | Eliminar un producto desde la lista de favoritos         | El producto se elimina de la lista de favoritos correctamente        | OK                 |
| #26 Políticas del producto    | Verificar el bloque de políticas                        | El título es visible y las políticas se muestran correctamente       | OK                 |
| #27 Compartir producto        | Hacer clic en el botón "compartir" de un producto        | Se abre una ventana emergente con opciones de redes sociales         | OK                 |
| #28 Puntuar producto          | Puntuar un producto con sistema de estrellas             | Se registra la puntuación de 1 a 5 estrellas correctamente           | OK                 |
| #28 Puntuar producto          | Escribir una reseña detallada de un producto            | La reseña se publica mostrando estrellas, nombre, fecha y comentario | OK                 |
| #28 Puntuar producto          | Verificar que solo usuarios con reserva finalizada pueden puntuar | Usuarios sin reserva finalizada no pueden puntuar el producto        | OK                 |
| #29 Eliminar categoría        | Eliminar una categoría desde el panel de administración   | La categoría se elimina correctamente tras confirmar la acción       | OK                 |

Todos los casos de prueba definidos para el Sprint 3 fueron ejecutados exitosamente.