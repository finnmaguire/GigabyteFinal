package application;

public interface IReceptionist {
	
	/**
	 * Method to add patient to the triage queue
	 */
	public void addPatientToTriage();
	
	/**
	 * Method to query the database for the patient details 
	 */
	public void searchPAS();

	

}
