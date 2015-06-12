package Generator;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

		/**************************************************************************************************************
		 * @author: jorge andres da costa
		 * @date 10/06/2015
		 * 
		 * crea una clase que interactue con la BBDD para aumentar los salarios llamando a la clse sesionManager y ha 
		 * empleado dao
		 * 
		 * *************************************************************************************************************/

public class EmpleadoServicios {

	EmpleadosDao empleados = new EmpleadosDao(); 					 //creo un objeto que instacie a EmpleadoDao
	
	
	public boolean incrementarsalarios(){
		
					//declaro un metodo para incrementar los salarios que me tendra que devolver un boolean
		
		Session sesion1 = null;									//creo un objeto sesion y lo igualo a null
		Transaction trasicion = null;							//declaro una transsaction que voya utilizar para la BBDD
		
		boolean com = false;										//declaro un boolean que sera el comprobador de result
		List<Employees> lista_empleados = null;						//declaro una lista de empleados que despues utilizare
		
			
		try{
			
			//abro un try, catch, finally para controlar el flujo y saber donde esta en cad amomento
			
		sesion1 = SesionManager.obtenerSesionNueva();				//invoco el metodo de obtenersesion del sesionmanager
		
		empleados.setSesion(sesion1);								//a empleados de EmpleadoDao le paso la sesion
		
		trasicion = empleados.getSesion().beginTransaction();		
		
					//cogo la sesion de EmpleadosDao para setear la transaction para interactuar con la BBDD
		
		lista_empleados = empleados.listaempleados();
		
					//la lista lista_empleados se iguala al metodo de listaempleados de la clase de EmpleadosDao
		
		
		salariosUp(lista_empleados);      							//llamo al metodo de subir el sueldo de esta clase
		
		trasicion.commit();											//hago comit de la sesion para guardar los cambios
		
		com = true;											//cambio el boolean a true para saber que lo ha hecho bien
		
		
		}													//fin try
		
		
		catch(Exception e){										//inicio el catch para tratar las excepciones
			
			System.out.println("algo ha ido mal");				//muestro en pantalla que algo a pasado
			
			trasicion.rollback();								//hago un rollback para volver a atras
			
			com = false;										//cambio el comprobador a false para saber que esta mal
			
			e.printStackTrace();
		}      //fin catch
		
		finally{				//inicio el finally
			
			SesionManager.cerrarSession(empleados.getSesion());    
			
				//invoco al metodo de cerrar sesion del "SesionManager" y le paso la sesion del objeto empleados
		
		}
		
		return com;								//devuelvo el boolean "comprobador"
		
					
	}
	private void salariosUp(List<Employees> lista_empleados){        
		
		//creo un metodo para subir el sueldo y le paso la lista lista_empleados
		
				
		for(Employees emp:lista_empleados){
			
			//creo un bucle for para interactuar con la lista de empleados 
			
			emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.2)));
			
			
			//seteo el salario que cojo y lo multiplico por 1.2 para aumentarlo
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
