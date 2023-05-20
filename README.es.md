#  gooFrete
<img src="images/brasil.png" alt="Bandeira dos Estados Unidos" width="30" height="30">[Versión Portugués](README.md) 
<img src="images/eua.png" alt="Bandeira dos Estados Unidos" width="30" height="30">[Versión Inglés](README.en.md) 

## Introducción
El sistema gooFrete tiene como objetivo ayudar en el proceso de carga en una empresa, con datos de transportistas, vehículos y viajes a realizar.

## Instalación
- Tener SQL Server Management Studio versión 19+;
- Ejecutar los scripts de creación de tablas contenidos en la carpeta de scripts;
- Descargue el proyecto ZIP, verifique si la versión java es compatible con la máquina, si no, modifique el archivo pom.xml;
- Agregue la dependencia AbsoluteLayout-RELEASE65.jar.

## Cómo utilizar
- El programa inicia en la ventana de inicio que contiene ocho campos, cada uno con la bandera del país y su respectivo idioma (Portugués, Inglés, Español, Japonés, Latín, Italiano, Francés y Alemán), también existe un campo en todas las ventanas, ubicado en el campo superior derecho, hay una imagen junto con la escritura “Logout” para cerrar las ventanas, (con el comando System.exit(0););
- Para registrar transportistas y vehículos, debe ingresar al menú “Inscripciones”, que contiene dos opciones;
Al seleccionar “Transportador”, se abre la ventana Registros > Transportista, donde debe ingresar datos, razón social, CNPJ/CPF, dirección, barrio, ciudad, estado, código postal, país, tipo de transportista, teléfono y hacer clic en el botón “Nuevo". El botón “Actualizar Matrícula” actualizará los datos del transportista, borrará los campos y actualizará la tabla;
- Al seleccionar “Vehículos” se abre la ventana Registros > Vehículos, a la izquierda se encuentra una tabla con las columnas tipo, modelo, marca, placa y ejes, si se ingresan correctamente los datos en los campos ubicados a la derecha, el la tabla se actualizará al hacer clic en el botón “Actualizar Registro”;
- Para visualizar las rutas/viajes, ingrese al menú “Rutas”, los viajes solo se pueden realizar cuando se vincula a un transportador y un vehículo;
- El campo Agregar destino acepta ciudades en el formato 'Cidade,UF', ejemplo: 'Curitiba,PR', Código IBGE y CEP, con o sin guión;
- Há a possibilidade de alterar a ordem dos destinos, para isso no campo inferior direito existem 2 botões, “Arriba” e “Abajo”, ao selecionar um item da tabela e clicar sobre o primeiro botão o item é realocado para um campo acima na tabla;
Para generar los reportes es necesario acceder al menú “Informes”, en el cual se encuentran 3 sectores para generar los respectivos reportes y al dar clic en el botón “Generar Informe” se exporta un archivo PDF a la carpeta de recursos en la raíz del proyecto.

## Funcionalidades
- Inscripciones:
Registrar transportistas, vehículos y realizar viajes;
- Nota: No hay forma de realizar un viaje sin la información del vehículo y del transportista;
- Cálculo de peaje;
- Informes:
Exportación de informes en PDF de transportadores, vehículos y viajes.cion

## Referencias:

#### Marco de Hibernación:
1. [https://hibernate.org](https://hibernate.org)
#### JDBC para servidor SQL:
2. [https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16](https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16)
#### Información de la API utilizada:
3. [https://rotasbrasil.com.br/configuracaoApi/v3](https://rotasbrasil.com.br/configuracaoApi/v3)
#### SQL Server Management Studio:
4. [https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16)
#### Tutorial JSON de Jackson:
5. [https://www.baeldung.com/jackson](https://www.baeldung.com/jackson)
