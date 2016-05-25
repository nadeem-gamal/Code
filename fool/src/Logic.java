import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "logic")
@ApplicationScoped
public class Logic {

	private int foolNumber = 0;
	private int ta3meaNumber = 0;
	private int batatesNumber = 0;
	private int batatesBaneehNumber = 0;
	private int batatesBoksomatNumber = 0;
	private int cheeseKareeshNumber = 0;
	
	private int shakshoukaNumber = 0;
	private int babaGhanougNumber = 0;


	public int getFoolNumber() {
		foolNumber = 0;
		for (Employee e : employeesList) {
			foolNumber += e.getFoolNumber();
		}
		return foolNumber;
	}

	public void setFoolNumber(int foolNumber) {
		this.foolNumber = foolNumber;
	}

	public int getTa3meaNumber() {
		ta3meaNumber = 0;
		for (Employee e : employeesList) {
			ta3meaNumber += e.getTa3meaNumber();
		}
		return ta3meaNumber;
	}

	public void setTa3meaNumber(int ta3meaNumber) {
		this.ta3meaNumber = ta3meaNumber;
	}

	public int getBatatesNumber() {
		batatesNumber = 0;
		for (Employee e : employeesList) {
			batatesNumber += e.getBatatesNumber();
		}
		return batatesNumber;
	}

	public void setBatatesNumber(int batatesNumber) {
		this.batatesNumber = batatesNumber;
	}

	private static List<Employee> employeesList = new ArrayList<Employee>();

	public Logic() {
		employeesList.add(((new Employee()).setName("Toba")));
		employeesList.add(((new Employee()).setName("Gharieb")));
		employeesList.add(((new Employee()).setName("Wael")));
		employeesList.add(((new Employee()).setName("Waled")));
		employeesList.add(((new Employee()).setName("Fawzy")));
		employeesList.add(((new Employee()).setName("Omar")));
		employeesList.add(((new Employee()).setName("Nadeem")));
		employeesList.add(((new Employee()).setName("Amr")));
		
		employeesList.add(((new Employee()).setName("Mahmoud Ramadan")));
		employeesList.add(((new Employee()).setName("Mohamed Ali")));
		employeesList.add(((new Employee()).setName("Sherief Usama")));
		employeesList.add(((new Employee()).setName("Sherief Shalaby")));
		employeesList.add(((new Employee()).setName("Abd el rahman")));
		
		employeesList.add(((new Employee()).setName("Kareem")));
	}

	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employee> employeesList) {
		Logic.employeesList = employeesList;
	}

	public int getBatatesBaneehNumber() {
		batatesBaneehNumber = 0;
		for (Employee e : employeesList) {
			batatesBaneehNumber += e.getBatatesBaneehNumber();
		}
		return batatesBaneehNumber;
	}

	public void setBatatesBaneehNumber(int batatesBaneehNumber) {
		this.batatesBaneehNumber = batatesBaneehNumber;
	}

	public int getBatatesBoksomatNumber() {
		batatesBoksomatNumber = 0;
		for (Employee e : employeesList) {
			batatesBoksomatNumber += e.getBatatesBoksomatNumber();
		}
		return batatesBoksomatNumber;
	}

	public void setBatatesBoksomatNumber(int batatesBoksomatNumber) {
		this.batatesBoksomatNumber = batatesBoksomatNumber;
	}

	public int getCheeseKareeshNumber() {
		cheeseKareeshNumber = 0;
		for (Employee e : employeesList) {
			cheeseKareeshNumber += e.getCheeseKareeshNumber();
		}
		return cheeseKareeshNumber;
	}

	public void setCheeseKareeshNumber(int cheeseKareeshNumber) {
		this.cheeseKareeshNumber = cheeseKareeshNumber;
	}
	
	public int getShakshoukaNumber() {
		shakshoukaNumber = 0;
		for(Employee e : employeesList){
			shakshoukaNumber += e.getShakshoukaNumber();
		}
		return shakshoukaNumber;
	}

	public void setShakshoukaNumber(int shakshoukaNumber) {
		this.shakshoukaNumber = shakshoukaNumber;
	}

	public int getBabaGhanougNumber() {
		babaGhanougNumber = 0;
		for(Employee e : employeesList){
			babaGhanougNumber += e.getBabaGhanougNumber();
		}
		return babaGhanougNumber;
	}

	public void setBabaGhanougNumber(int babaGhanougNumber) {
		this.babaGhanougNumber = babaGhanougNumber;
	}


	public double getTotalPrice() {
		double totalPrice = 0;
		for (Employee e : employeesList) {
			totalPrice += e.getPrice();
		}
		return totalPrice;
	}
	
	public static String updateUser(Employee user) {
		for (Employee e : employeesList) {
			if (e.getName().equals(user.getName())) {
				e.setFoolNumber(user.getFoolNumber());
				e.setTa3meaNumber(user.getTa3meaNumber());
				e.setBatatesNumber(user.getBatatesNumber());
				e.setBatatesBaneehNumber(user.getBatatesBaneehNumber());
				e.setBatatesBoksomatNumber(user.getBatatesBoksomatNumber());
				e.setCheeseKareeshNumber(user.getCheeseKareeshNumber());
				e.setShakshoukaNumber(user.getShakshoukaNumber());
				e.setBabaGhanougNumber(user.getBabaGhanougNumber());
			}
		}
		return "index";
	}

//	private JasperPrint jasperPrint = null;
//
//	public void initDownload() throws JRException {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("foolNumber", foolNumber);
//
////		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
////				employeesList);
//		jasperPrint = JasperFillManager.fillReport(
//				"E:\\work\\ireport-reports\\old\\report1fool.jasper", map);
//	}
//
//	public void downloadAsPDF() throws JRException, IOException {
//		initDownload();
//		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
//				.getCurrentInstance().getExternalContext().getResponse();
//
//		httpServletResponse.addHeader("Content-disposition",
//				"attachment; filename=report.pdf");
//
//		ServletOutputStream servletOutputStream = httpServletResponse
//				.getOutputStream();
//		JasperExportManager.exportReportToPdfStream(jasperPrint,
//				servletOutputStream);
//		servletOutputStream.flush();
//		servletOutputStream.close();
//		// httpServletResponse.flushBuffer();
//	}

}
