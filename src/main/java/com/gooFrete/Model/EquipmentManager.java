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
public class EquipmentManager {
 
    private String connectionString =
                       "jdbc:sqlserver://localhost;"
                       + "database=gooFrete;"
                       + "user=sa;"
                       + "password=P@ssw0rd!;"
                       + "encrypt=true;"
                       + "trustServerCertificate=true;"
                       + "hostNameInCertificate=*.database.windows.net;"
                       + "loginTimeout=30;";
    
    public EquipmentManager() {
    }
    
    public boolean equipmentInsert(Equipment veiculo){
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
                                   insert into [carrier].[Equipment]
                                   values
                                   (newid(),'""" + veiculo.getEquipmentType() + 
                "','" + veiculo.getModelo() +
                "','" + veiculo.getMarca() + 
                "','" + veiculo.getEixos() + 
                "','" + veiculo.getLicensePlate() + 
                "','" + getCarrierId(veiculo.getTransportadorVinculado()) + "',getdate());";
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
    
    public List<Equipment> equipmentQueryAll(){

        String equipmentType, modelo, marca, licensePlate, transportadorVinculado;
        int eixos;
        Equipment veiculo;      
        List <Equipment>veiculos = new ArrayList();
        
        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String selectSql = "select type, modelo, marca, eixos, licensePlate from [carrier].[Equipment]";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(selectSql);
        
                // Create results from select statement
                while (resultSet.next()) {
                        equipmentType = resultSet.getString(1);
                        modelo = resultSet.getString(2);
                        marca = resultSet.getString(3);
                        eixos = Integer.parseInt(resultSet.getString(4));
                        licensePlate = resultSet.getString(5);
                        transportadorVinculado = null;
                        veiculo = new Equipment(equipmentType, modelo, marca, licensePlate, eixos, transportadorVinculado);
                        veiculos.add(veiculo);
                        }
        return veiculos;
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
    
    public Equipment equipmentQueryOneEquipment(String keyLicensePlate){

        String equipmentType, modelo, marca, licensePlate, transportadorVinculado;
        int eixos;
        Equipment veiculo = null;
        
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
                                   select a.type, a.modelo, a.marca, a.eixos, a.licensePlate, b.CarrierName from [carrier].[Equipment] a
                                   inner join [carrier].[Carrier] b on b.Id = a.CarrierId
                                   where a.licensePlate in (
                                   '""" + keyLicensePlate + "'" +
                                   ");";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(selectSql);
        
                // Create results from select statement
                while (resultSet.next()) {
                    equipmentType = resultSet.getString(1);
                        modelo = resultSet.getString(2);
                        marca = resultSet.getString(3);
                        eixos = Integer.parseInt(resultSet.getString(4));
                        licensePlate = resultSet.getString(5);
                        transportadorVinculado = resultSet.getString(6);
                        veiculo = new Equipment(equipmentType, modelo, marca, licensePlate, eixos, transportadorVinculado);
                }
                return veiculo;
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
    
    public String getCarrierId(String keyCarrierName){

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
                                   where carrierName in (
                                   '""" + keyCarrierName + "'" +
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
 
    public String equipmentExiste(String keyLicensePlate){

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
                                   select id from [carrier].[Equipment]
                                   where licensePlate in (
                                   '""" + keyLicensePlate + "'" +
                                   ");";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(selectSql);
                
                
                // 6. Verificar se o registro existe
                if (resultSet.next()) {
                    System.out.println("Registro de veículo encontrado!");
                    //while (resultSet.next()) {
                        situacao = resultSet.getString(1);
                    //}
                    return situacao;
                } else {
                    System.out.println("Registro de veículo não encontrado.");
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
    
    public boolean equipmentUpdate(Equipment veiculo, String EquipmentID){
        // Declare the JDBC objects.
        Connection connection = null;
        PreparedStatement prepsInsert = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String updateSql = """
                                   update [carrier].[Equipment]
                                   set
                                   type = '""" + veiculo.getEquipmentType()+ 
                "', modelo = '" + veiculo.getModelo()+
                "', marca = '" + veiculo.getMarca()+ 
                "', eixos = " + veiculo.getEixos()+ 
                ", licensePlate = '" + veiculo.getLicensePlate()+ 
                "', carrierId = '" + getCarrierId(veiculo.getTransportadorVinculado()) + "' where id in ( " +
                                   "'" + EquipmentID + "'" +
                                   ");";
                System.out.println(updateSql);
                prepsInsert = connection.prepareStatement(updateSql);
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
    
    public boolean equipmentDelete(String licensePlate){
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
                                   delete from [carrier].[Equipment]
                                   where licensePlate in (
                                   '""" + licensePlate + "'" +
                                   ");";
                
                System.out.println(deteleSql);
                prepsInsert = connection.prepareStatement(deteleSql);
                prepsInsert.executeUpdate();
                return true;
        }
        catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro na exclusão de veículo.");
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
    
    public List<Equipment> getLinkedCarrierEquipment(String carrierId){

        String equipmentType, modelo, marca, licensePlate, transportadorVinculado;
        int eixos;
        Equipment veiculo;      
        List <Equipment>veiculos = new ArrayList();
        
        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement prepsInsertProduct = null;

        try {
                connection = DriverManager.getConnection(connectionString);

                // Create and execute a SELECT SQL statement.
                String selectSql = "select type, modelo, marca, eixos, licensePlate from [carrier].[Equipment] where carrierId = '" + carrierId + "';";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(selectSql);
        
                // Create results from select statement
                while (resultSet.next()) {
                        equipmentType = resultSet.getString(1);
                        modelo = resultSet.getString(2);
                        marca = resultSet.getString(3);
                        eixos = Integer.parseInt(resultSet.getString(4));
                        licensePlate = resultSet.getString(5);
                        transportadorVinculado = null;
                        veiculo = new Equipment(equipmentType, modelo, marca, licensePlate, eixos, transportadorVinculado);
                        veiculos.add(veiculo);
                        }
        return veiculos;
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
    
}
