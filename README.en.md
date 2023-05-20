#  gooFrete
<img src="images/brasil.png" alt="Bandeira dos Estados Unidos" width="30" height="30">[Portuguese version](README.md) 
<img src="images/espanha.png" alt="Bandeira dos Estados Unidos" width="30" height="30">[Spanish version](README.en.md) 

## Introduction
The purpose of the gooFrete system is to assist in the freight process in a company, with data on carriers, vehicles and trips to be made.

## Installation
- Have SQL Server Management Studio version 19+;
- Run the table creation scripts contained in the scripts folder;
- Download the ZIP project, check if the java version is compatible with the machine, if not, modify the pom.xml file;
- Add the AbsoluteLayout-RELEASE65.jar dependency. 

## How to use
- The program starts in the home window that contains eight fields, each with the country's flag and its respective language (Portuguese, English, Spanish, Japanese, Latin, Italian, French and German), there is also a field in all windows , located in the upper right field, there is an image together with the writing “Logout” to close the windows, (with the command System.exit(0););
- To register carriers and vehicles, you must enter the “Registrations” menu, which contains two options;
When selecting "Carrier", the Registration > Transport window opens, where you must enter data, company name, CNPJ/CPF, address, neighborhood, city, state, zip code, country, type of carrier, telephone and click on the "New" button . The “Update Registration” button will update the transporter's data, clear the fields and update the table;
- When selecting “Vehicles”, the Registration > Vehicles window opens, on the left there is a table with the columns type, model, brand, license plate and axles, if the data in the fields located on the right are inserted correctly, the table will be updated when clicking on the button “Update Registration”;
- To view the routes/trips, enter the “Routes” menu, trips can only be carried out when linked to a transporter and a vehicle;
- The Add destination field accepts cities in the format 'Cidade,UF', example: 'Curitiba,PR', IBGE Code and CEP, with or without a hyphen;
- There is the possibility of changing the order of the destinations, for that in the lower right field there are 2 buttons, “Up” and “Down”, when selecting an item from the table and clicking on the first button the item is relocated to a field above in the table;
To generate the reports it is necessary to access the “Reports” menu, in which there are 3 sectors to generate the respective reports and when clicking on the “Generate Report” button a PDF file is exported to the resources folder in the root of the project.

## Functionalities
- Registrations:
Register transporters, vehicles and carry out trips;
- Note: There is no way to make a trip without vehicle and carrier information;
- Toll calculation;
- Reports:
PDF report export of transporters, vehicles and trips.

## References:

#### Framework Hibernate:
1. [https://hibernate.org](https://hibernate.org)
#### JDBC for SQLServer:
2. [https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16](https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16)
#### API information used:
3. [https://rotasbrasil.com.br/configuracaoApi/v3](https://rotasbrasil.com.br/configuracaoApi/v3)
#### SQL Server Management Studio:
4. [https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16)
#### Jackson JSON Tutorial:
5. [https://www.baeldung.com/jackson](https://www.baeldung.com/jackson)
