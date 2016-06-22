package com.cooksys.ftd.kata.model;

public class Species implements Comparable<Species> {

	private String name;
	private GrowthModel growthModel;
	private double tolerance;

	public Species() {
		super();
	}

	public Species(String name, GrowthModel growthModel, double tolerance) {
		super();
		this.name = name;
		this.growthModel = growthModel;
		this.tolerance = tolerance;
	}

	public boolean isMember(GrowthModel growthModel) {
		return ((Math.abs(this.growthModel.getLengthToWingspan() - growthModel.getLengthToWingspan())
				/ this.growthModel.getLengthToWingspan()) < this.getTolerance()
				&& (Math.abs(this.growthModel.getLeavesEatenToWeight() - growthModel.getLeavesEatenToWeight())
						/ this.growthModel.getLeavesEatenToWeight()) < this.getTolerance());
	}
	

	@Override
	public int compareTo(Species that) {
		return this.name.compareTo(that.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GrowthModel getGrowthModel() {
		return growthModel;
	}

	public void setGrowthModel(GrowthModel growthModel) {
		this.growthModel = growthModel;
	}

	public double getTolerance() {
		return tolerance;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}

	@Override
	public String toString() {
		return "Species [name=" + name + ", growthModel=" + growthModel + ", tolerance=" + tolerance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((growthModel == null) ? 0 : growthModel.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tolerance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Species other = (Species) obj;
		if (growthModel == null) {
			if (other.growthModel != null)
				return false;
		} else if (!growthModel.equals(other.growthModel))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(tolerance) != Double.doubleToLongBits(other.tolerance))
			return false;
		return true;
	}

}
