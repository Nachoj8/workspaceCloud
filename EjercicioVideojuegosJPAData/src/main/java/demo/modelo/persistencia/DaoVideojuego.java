package demo.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.modelo.entidad.Videojuego;


//Para crear el DAO tenemos que crear una INTERFACE que extienda
//de JpaRepository parametrizar dos valores
//1- Coche, que seria la entidad que queremos mapear
//2- El tipo de clave primaria de la entidad que estamos mapeando

//Lo ultimo que tenemos que hacer, como es una app Spring, es
//dar de alta este objeto en el contexto de springh
@Repository
public interface DaoVideojuego extends JpaRepository<Videojuego, Integer>{

}
