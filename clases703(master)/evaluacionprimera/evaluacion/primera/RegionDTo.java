package evaluacion.primera;



/*
 * author:jorge andres da costa
 * crear una aplicacion que siguiendo el patron DAO que me permita crear nuevas regiones Recuperar dado 
 * su identificador y rececuperar toda la lista de regiones.
 * se valora numero de clases, nuemero de metodos, eestructura, claridad de codigo y documentacion.
 * 
 * NAME: este es el metodo donde se pone el objeto region con sus atributos.
 * 
 * */
public class RegionDTo {
	/**
	 * se setean  las variables de ATTRIB
	 * 
	 * */
	private int regionID;
	private String regionName;
	
	public RegionDTo(int regionID, String regionName){
		
		this.regionID = regionID;
		this.regionName = regionName;
	/*
	 * declaramos el constructor 
	 * con sus seters a getters
	 * */	
	}

	public int getRegionID() {
		return regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	
	
}
