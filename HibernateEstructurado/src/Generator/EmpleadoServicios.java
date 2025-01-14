package Generator;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**************************************************************************************************************
 * @author: jorge andres da costa																			  *
 * @date 10/06/2015
 * 
 *       crea una clase que interactue con la BBDD para aumentar los salarios
 *       llamando a la clse sesionManager y ha empleado dao
 * 
 **************************************************************************************************************/

public class EmpleadoServicios {

	EmpleadosDao empleados = new EmpleadosDao(); // creo un objeto que instacie
													// a EmpleadoDao

	public boolean incrementarsalarios() {

		// declaro un metodo para incrementar los salarios que me tendra que
		// devolver un boolean

		Session sesion1 = null; // creo un objeto sesion y lo igualo a null
		Transaction trasicion = null; // declaro una transsaction que voya
										// utilizar para la BBDD

		boolean com = false; // declaro un boolean que sera el comprobador de
								// result
		List<Employees> lista_empleados = null; // declaro una lista de
												// empleados que despues
												// utilizare

		try {

			// abro un try, catch, finally para controlar el flujo y saber donde
			// esta en cad amomento

			sesion1 = SesionManager.obtenerSesionNueva(); // invoco el metodo de
															// obtenersesion del
															// sesionmanager

			empleados.setSesion(sesion1); // a empleados de EmpleadoDao le paso
											// la sesion

			trasicion = empleados.getSesion().beginTransaction();

			// cogo la sesion de EmpleadosDao para setear la transaction para
			// interactuar con la BBDD

			lista_empleados = empleados.listaempleados();

			// la lista lista_empleados se iguala al metodo de listaempleados de
			// la clase de EmpleadosDao

			salariosUp(lista_empleados); // llamo al metodo de subir el sueldo
											// de esta clase

			trasicion.commit(); // hago comit de la sesion para guardar los
								// cambios

			com = true; // cambio el boolean a true para saber que lo ha hecho
						// bien

		} // fin try

		catch (Exception e) { // inicio el catch para tratar las excepciones

			System.out.println("algo ha ido mal"); // muestro en pantalla que
													// algo a pasado

			trasicion.rollback(); // hago un rollback para volver a atras

			com = false; // cambio el comprobador a false para saber que esta
							// mal

			e.printStackTrace();
		} // fin catch

		finally { // inicio el finally

			SesionManager.cerrarSession(empleados.getSesion());

			// invoco al metodo de cerrar sesion del "SesionManager" y le paso
			// la sesion del objeto empleados

		}
		if (com = true) {
			System.out.println("se ha aumentado el sueldo a todos los empleados");
		}
		return com; // devuelvo el boolean "comprobador"
		
	}

	private void salariosUp(List<Employees> lista_empleados) {

		// creo un metodo para subir el sueldo y le paso la lista
		// lista_empleados

		for (Employees emp : lista_empleados) {

			// creo un bucle for para interactuar con la lista de empleados

			emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.2)));
			System.out.println(emp.getFirstName() + emp.getLastName() + " pasa a cobrar " + emp.getSalary().intValue());
			// seteo el salario que cojo y lo multiplico por 1.2 para aumentarlo

		}

	}
	public boolean maximoempleado(){
		
		Session sesion3 = null;
		boolean com2 = false;
		Transaction transicion2 = null;
		List<Employees> lista_sueldos = null;
		Iterator<Employees> ite2 = null;
		
		try{
			sesion3 = SesionManager.obtenerSesionNueva();
			empleados.setSesion(sesion3);
			transicion2 = empleados.getSesion().beginTransaction();
			lista_sueldos = empleados.maximoSalario();
			ite2 = lista_sueldos.iterator();
			
			while(ite2.hasNext()){
				Employees emp = ite2.next();
				
				System.out.println(emp.getFirstName() + " que pertenece al departamento " + emp.getDepartments().getDepartmentName() + 
						" cobra " + emp.getSalary().intValue());
				
		
		
			}
			
		transicion2.commit();
		com2 = true;
		}
		catch(Exception e){
			System.out.println("algo esta pasando que no funciona");
			transicion2.rollback();
			com2 = false;
			e.printStackTrace();
		}
		finally{
			SesionManager.cerrarSession(sesion3);
		}
		return com2;
	}
	public boolean empleadosDep(){
		boolean com3 = false;
		Session sesion4 = null;
		Transaction transicion4 = null;
		Scanner in = new Scanner(System.in);
		System.out.println("que departamento quieres que se muestre");
		int dep = in.nextInt();
		List<Employees> lista_EmpDep = null;
		Iterator<Employees> ite4 = null;
		try{
			sesion4 = SesionManager.obtenerSesionNueva();
			empleados.setSesion(sesion4);
			transicion4 = empleados.getSesion().beginTransaction();
			lista_EmpDep = empleados.empleadosDep(dep);
				ite4 = lista_EmpDep.iterator();
				while(ite4.hasNext()){
					Employees emp3 =ite4.next();
					System.out.println("estos empleados pertenecen al departamento seleccionado" + " " +
					emp3.getDepartments().getDepartmentName());
					System.out.println(emp3.getFirstName() + " " + emp3.getLastName() );
				}
		com3 = true;	
		}
		catch(Exception e){
			e.printStackTrace();
			transicion4.rollback();
			System.out.println("ha habido un terrible error :(");
			com3 = false;
		}
		finally{
			SesionManager.cerrarSession(sesion4);
		}
		
		
		
		return com3;
	}
	public boolean bajarsueldos(){
		Session sesion5 = null;
		Transaction trasicion = null;
		boolean todoOk = false;
		
		List<Employees> lista_empleados2 = null;
		try{
			sesion5 = SesionManager.obtenerSesionNueva();
			empleados.setSesion(sesion5);
			trasicion = sesion5.beginTransaction();
			lista_empleados2 = empleados.listaempleados();
			salariosDown(lista_empleados2);
			trasicion.commit();
			todoOk = true;			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("algo ha ido mal :(");
			trasicion.rollback();
		}
		finally{
			SesionManager.cerrarSession(sesion5);
		}
		if(todoOk == true){
			System.out.println(" se ha bajado los sueldos ");
		}
		return todoOk;
		
	}
	private void salariosDown(List<Employees> lista_empleado2){
		
		Scanner in = new Scanner(System.in);
		System.out.println("selecione el porcentaje de bajada de sueldo ");
		BigDecimal por = in.nextBigDecimal();
		in.close();
		for (Employees emp : lista_empleado2) {
			
			emp.setSalary(emp.getSalary().multiply(por));
			System.out.println("El empleado " + emp.getFirstName() + emp.getLastName() + " pasara a cobrar " + emp.getSalary());
			
		}
	}
	
}
