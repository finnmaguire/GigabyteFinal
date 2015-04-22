package application;

public class Doctor extends Staff implements IDoctor, ICategorise {

	/**
	 * Vars for the class
	 */
	private boolean statusAE;
	private boolean statusOnCall;

	/**
	 * Default constructor
	 */
	public Doctor() {

	}

	/**
	 * Constructor with args
	 */
	public Doctor(boolean statusOnCall) {
		statusOnCall = this.statusOnCall;
	}

	

	/**
	 * Boolean to see if staff are on call
	 * 
	 * @return statusOnCall
	 */
	public boolean isStatusOnCall() {
		return statusOnCall;
	}

	/**
	 * Setter method for statusOnCall
	 * 
	 * @param statusOnCall
	 */
	public void setStatusOnCall(boolean statusOnCall) {
		this.statusOnCall = statusOnCall;
	}

	/**
	 * Method to allocate extra time to a patient in 5 min increments
	 */
	@Override
	public void allocateExtraTime() {

	}

	/**
	 * Method to catagorise patients for treatment
	 * (Only used by triage nurse, to be left empty)
	 */
	@Override
	public void categorisePatient() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Recatagorise patient's severity level in the A and E queue 
	 */
	@Override
	public void recategorisePatient() {
		// TODO Auto-generated method stub
		
	}

}
