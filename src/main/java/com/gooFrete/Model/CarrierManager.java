package com.gooFrete.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauricio.rodrigues
 */
public class CarrierManager {

    private String connectionString =
                       "jdbc:sqlserver://localhost;"
                       + "database=gooFrete;"
                       + "user=sa;"
                       + "password=P@ssw0rd!;"
                       + "encrypt=true;"
                       + "trustServerCertificate=true;"
                       + "hostNameInCertificate=*.database.windows.net;"
                       + "loginTimeout=30;";
    
    public CarrierManager() {
    }
    
    public boolean carrierInsert(Carrier transportador){
        // Declare the JDBC objects.
        Connection connection = null;
        PreparedStatement prepsInsert = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String insertSql = """
                                   insert into [carrier].[Carrier]
                                   values
                                   (newid(),'""" + transportador.getCarrierName() + 
                "','" + transportador.getCarrierCNPJCPF() +
                "','" + transportador.getAddress() + 
                "','" + transportador.getDistrict() + 
                "','" + transportador.getCity() + 
                "','" + transportador.getState() + 
                "','" + transportador.getCountry() + 
                "','" + transportador.getZipcode() +
                "','" + transportador.getTelefone() +
                "'," + transportador.getCarrierType() + ",getdate());";
                System.out.println(insertSql);
                prepsInsert = connection.prepareStatement(insertSql);
                prepsInsert.executeUpdate();
                return true;
        }
        catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro na persistência de dados do transportador.");
                return false;
        }
        finally {
                // Close the connections after the data has been handled.
                if (prepsInsertProduct != null) try { prepsInsertProduct.close(); } catch(Exception e) {}
                if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
                if (resultSet2 != null) try { resultSet2.close(); } catch(Exception e) {}
                if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }
    
    public List<Carrier> carrierQueryAll(){

        String carrierName, carrierCNPJCPF, address,district, city, state, country, zipcode, phone;
        int carrierType;
        Carrier transportador;      
        List <Carrier>transportadores = new ArrayList();
        
        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String selectSql = "select carrierName,carrierCNPJCPF,address,district,city,state,country,zipcode,phone, type from [carrier].[Carrier] order by carrierName";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(selectSql);
        
                // Create results from select statement
                while (resultSet.next()) {
                        carrierName = resultSet.getString(1);
                        carrierCNPJCPF = resultSet.getString(2);
                        address = resultSet.getString(3);
                        district = resultSet.getString(4);
                        city = resultSet.getString(5);
                        state = resultSet.getString(6);
                        country = resultSet.getString(7);
                        zipcode = resultSet.getString(8);
                        phone = resultSet.getString(9);
                        carrierType = Integer.parseInt(resultSet.getString(10));
                        transportador = new Carrier(carrierName, carrierCNPJCPF, address, district, city, state, country, zipcode, phone, carrierType);
                        transportadores.add(transportador);
                        }
        return transportadores;
        }
        catch (Exception e) {
                e.printStackTrace();
                return null;
        }
        finally {
                // Close the connections after the data has been handled.
                if (prepsInsertProduct != null) try { prepsInsertProduct.close(); } catch(Exception e) {}
                if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
                if (resultSet2 != null) try { resultSet2.close(); } catch(Exception e) {}
                if (statement != null) try { statement.close(); } catch(Exception e) {}
                if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }
    
    public boolean carrierDelete(String carrierCNPJCPF){
        // Declare the JDBC objects.
        Connection connection = null;
        PreparedStatement prepsInsert = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String deteleSql = """
                                   delete from [carrier].[Carrier]
                                   where carrierCNPJCPF in (
                                   '""" + carrierCNPJCPF + "'" +
                                   ");";
                
                System.out.println(deteleSql);
                prepsInsert = connection.prepareStatement(deteleSql);
                prepsInsert.executeUpdate();
                return true;
        }
        catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro na exclusão de transportador.");
                return false;
        }
        finally {
                // Close the connections after the data has been handled.
                if (prepsInsertProduct != null) try { prepsInsertProduct.close(); } catch(Exception e) {}
                if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
                if (resultSet2 != null) try { resultSet2.close(); } catch(Exception e) {}
                if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }
    
    public Carrier carrierQueryOneCarrier(String keyCNPJCPF){

        String carrierName, carrierCNPJCPF, address,district, city, state, country, zipcode, phone;
        int carrierType;
        Carrier transportador = null;      
        
        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String selectSql = """
                                   select carrierName,carrierCNPJCPF,address,district,
                                   city,state,country,zipcode,phone, type from [carrier].[Carrier]
                                   where carrierCNPJCPF in (
                                   '""" + keyCNPJCPF + "'" +
                                   ");";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(selectSql);
        
                // Create results from select statement
                while (resultSet.next()) {
                    carrierName = resultSet.getString(1);
                    carrierCNPJCPF = resultSet.getString(2);
                    address = resultSet.getString(3);
                    district = resultSet.getString(4);
                    city = resultSet.getString(5);
                    state = resultSet.getString(6);
                    country = resultSet.getString(7);
                    zipcode = resultSet.getString(8);
                    phone = resultSet.getString(9);
                    carrierType = Integer.parseInt(resultSet.getString(10));
                    transportador = new Carrier(carrierName, carrierCNPJCPF, address, district, city, state, country, zipcode, phone, carrierType);
                }
                return transportador;
        }
        catch (Exception e) {
                e.printStackTrace();
                return null;
        }
        finally {
                // Close the connections after the data has been handled.
                if (prepsInsertProduct != null) try { prepsInsertProduct.close(); } catch(Exception e) {}
                if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
                if (resultSet2 != null) try { resultSet2.close(); } catch(Exception e) {}
                if (statement != null) try { statement.close(); } catch(Exception e) {}
                if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }
    
    public String carrierExiste(String keyCNPJCPF){

        String situacao = "consultaIniciada";
        
        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String selectSql = """
                                   select id from [carrier].[Carrier]
                                   where carrierCNPJCPF in (
                                   '""" + keyCNPJCPF + "'" +
                                   ");";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(selectSql);
                
                
                // 6. Verificar se o registro existe
                if (resultSet.next()) {
                    System.out.println("Registro de transportador encontrado!");
                    //while (resultSet.next()) {
                        situacao = resultSet.getString(1);
                    //}
                    return situacao;
                } else {
                    System.out.println("Registro de transportador não encontrado.");
                    situacao = "semCadastro";
                    return situacao;
                }
        }
        catch (Exception e) {
                e.printStackTrace();
                return "erro";
        }
        finally {
                // Close the connections after the data has been handled.
                if (prepsInsertProduct != null) try { prepsInsertProduct.close(); } catch(Exception e) {}
                if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
                if (resultSet2 != null) try { resultSet2.close(); } catch(Exception e) {}
                if (statement != null) try { statement.close(); } catch(Exception e) {}
                if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }
    
    public boolean carrierUpdate(Carrier transportador, String CarrierID){
        // Declare the JDBC objects.
        Connection connection = null;
        PreparedStatement prepsInsert = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String insertSql = """
                                   update [carrier].[Carrier]
                                   set
                                   carrierName = '""" + transportador.getCarrierName() + 
                "', carrierCNPJCPF = '" + transportador.getCarrierCNPJCPF() +
                "', address = '" + transportador.getAddress() + 
                "', district = '" + transportador.getDistrict() + 
                "', city = '" + transportador.getCity() + 
                "', state = '" + transportador.getState() + 
                "', country = '" + transportador.getCountry() + 
                "', zipcode = '" + transportador.getZipcode() +
                "', phone = '" + transportador.getTelefone() +
                "', type = " + transportador.getCarrierType() + " where id in ( " +
                                   "'" + CarrierID + "'" +
                                   ");";
                System.out.println(insertSql);
                prepsInsert = connection.prepareStatement(insertSql);
                prepsInsert.executeUpdate();
                return true;
        }
        catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro na persistência de dados do transportador.");
                return false;
        }
        finally {
                // Close the connections after the data has been handled.
                if (prepsInsertProduct != null) try { prepsInsertProduct.close(); } catch(Exception e) {}
                if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
                if (resultSet2 != null) try { resultSet2.close(); } catch(Exception e) {}
                if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }
    
}
