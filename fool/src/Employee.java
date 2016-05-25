public class Employee {

	private String name = "";

	private int foolNumber = 0;
	private int ta3meaNumber = 0;
	private int batatesNumber = 0;

	private int batatesBaneehNumber = 0;
	private int batatesBoksomatNumber = 0;
	private int cheeseKareeshNumber = 0;
	
	private int shakshoukaNumber = 0;
	private int babaGhanougNumber = 0;

	private double price = 0;

	public double getPrice() {
		price = (foolNumber * 1.5) + (ta3meaNumber * 1.5)
				+ (batatesNumber * 2.5) + (batatesBaneehNumber * 2.5)
				+ (batatesBoksomatNumber * 2.5) + (cheeseKareeshNumber * 2.5)
				+ (shakshoukaNumber * 2.5) + (babaGhanougNumber * 2.5);
//		if (price != 0) {
//			price += 1;
//		}
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
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
}
