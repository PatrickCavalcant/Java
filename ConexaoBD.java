package com.ifg.agenda;

//Classe ConexaoBD - Faz a conex�o com o banco de dados

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

 //Nome do usu�rio do postgresql
 private static final String USERNAME = "postgres";

 //Senha do postgresql
 private static final String PASSWORD = "123";

 //Dados de caminho, porta e nome da base de dados que ir� ser feita a conex�o
 private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/agenda";
 /**
 * Cria uma conex�o com o banco de dados postgresql utilizando o nome de usu�rio e senha fornecidos
 * @param username
 * @param senha
 * @return uma conex�o com o banco de dados
 * @throws Exception
 */
 public static Connection createConnectionToPostgresql() throws Exception{
    Class.forName("org.postgresql.Driver"); //Faz com que a classe seja carregada pela JVM

    //Cria a conex�o com o banco de dados
    Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

    return connection;
 }
}


