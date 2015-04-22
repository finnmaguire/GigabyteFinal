package application;

public class TriageNurse extends Staff implements IJDoe, ICategorise  {

	public TriageNurse() {
		
	}

	/**
	 * Method to catagorise patient severity for the A and E queue
	 */
	@Override
	public void categorisePatient() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method to recatagorise patient severity for the tirage queue
	 */
	@Override
	public void recategorisePatient() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method to allocate name to so a JDOE can be placed into the queue
	 */
	@Override
	public String allocateFirstNameJDoe() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to alllocate last name 
	 */
	@Override
	public String allocatelastNameJDoe() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to allocate random NHS number to JDOE
	 */
	@Override
	public int allocateNHSNumberJDoe() {
		// TODO Auto-generated method stub
		return 0;
	}

}
