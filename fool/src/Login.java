import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "login")
@SessionScoped
public class Login {

	private List<String> employeeNames = new ArrayList<String>();

	private String employeeName = "";
	
	private int foolNumber = 0;
	private int ta3meaNumber = 0;
	private int batatesNumber = 0;
	private int batatesBaneehNumber = 0;
	private int batatesBoksomatNumber = 0;
	private int cheeseKareeshNumber = 0;
	
	private int shakshoukaNumber = 0;
	private int babaGhanougNumber = 0;

	public Login() {
		employeeNames.add("");
		employeeNames.add("Toba");
		employeeNames.add("Gharieb");
		employeeNames.add("Wael");
		employeeNames.add("Waled");
		employeeNames.add("Fawzy");
		employeeNames.add("Omar");
		employeeNames.add("Nadeem");
		employeeNames.add("Amr");
		
		employeeNames.add("Mahmoud Ramadan");
		employeeNames.add("Mohamed Ali");
		employeeNames.add("Sherief Usama");
		employeeNames.add("Sherief Shalaby");
		employeeNames.add("Abd el rahman");
		
		employeeNames.add("Kareem");
	}

	public List<String> getEmployeeNames() {
		return employeeNames;
	}

	public void setEmployeeNames(List<String> employeeNames) {
		this.employeeNames = employeeNames;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getFoolNumber() {
		return foolNumber;
	}

	public void setFoolNumber(int foolNumber) {
		this.foolNumber = foolNumber;
	}

	public int getTa3meaNumber() {
		return ta3meaNumber;
	}

	public void setTa3meaNumber(int ta3meaNumber) {
		this.ta3meaNumber = ta3meaNumber;
	}

	public int getBatatesNumber() {
		return batatesNumber;
	}

	public void setBatatesNumber(int batatesNumber) {
		this.batatesNumber = batatesNumber;
	}
	
	

	public int getBatatesBaneehNumber() {
		return batatesBaneehNumber;
	}

	public void setBatatesBaneehNumber(int batatesBaneehNumber) {
		this.batatesBaneehNumber = batatesBaneehNumber;
	}

	public int getBatatesBoksomatNumber() {
		return batatesBoksomatNumber;
	}

	public void setBatatesBoksomatNumber(int batatesBoksomatNumber) {
		this.batatesBoksomatNumber = batatesBoksomatNumber;
	}

	public int getCheeseKareeshNumber() {
		return cheeseKareeshNumber;
	}

	public void setCheeseKareeshNumber(int cheeseKareeshNumber) {
		this.cheeseKareeshNumber = cheeseKareeshNumber;
	}
	
	public int getShakshoukaNumber() {
		return shakshoukaNumber;
	}

	public void setShakshoukaNumber(int shakshoukaNumber) {
		this.shakshoukaNumber = shakshoukaNumber;
	}

	public int getBabaGhanougNumber() {
		return babaGhanougNumber;
	}

	public void setBabaGhanougNumber(int babaGhanougNumber) {
		this.babaGhanougNumber = babaGhanougNumber;
	}

	public void saveUser(){
		Employee e = new Employee();
		e.setName(employeeName);
		e.setFoolNumber(foolNumber);
		e.setTa3meaNumber(ta3meaNumber);
		e.setBatatesNumber(batatesNumber);
		
		e.setBatatesBaneehNumber(batatesBaneehNumber);
		e.setBatatesBoksomatNumber(batatesBoksomatNumber);
		e.setCheeseKareeshNumber(cheeseKareeshNumber);
		
		e.setShakshoukaNumber(shakshoukaNumber);
		e.setBabaGhanougNumber(babaGhanougNumber);
		
		Logic.updateUser(e);
	}
}
