package org.contactCars.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.contactCars.dal.orm.Car;
import org.contactCars.dal.services.CarService;

@ManagedBean(name = "cars")
@ViewScoped
public class Cars extends BaseBean {

	private Car car;
	private List<Car> carList;

	public Cars() {
		super();
		init();
	}

	private void init() {
		carList = CarService.getAllCars();
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

}
