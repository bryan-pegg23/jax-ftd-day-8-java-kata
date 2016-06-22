package com.cooksys.ftd.kata.model;

public class Sample implements Comparable<Sample> {

	private Butterpillar butterpillar;
	private Catterfly catterfly;

	public Sample() {
		super();
	}

	public Sample(Butterpillar butterpillar, Catterfly catterfly) {
		super();
		this.butterpillar = butterpillar;
		this.catterfly = catterfly;
	}
	
	@Override
	public int compareTo(Sample that) {
		if (this.butterpillar.compareTo(that.butterpillar) != 0) {
			return this.butterpillar.compareTo(that.butterpillar);
		} else  {
			return this.catterfly.compareTo(that.catterfly);
		}
	}
	
	public GrowthModel getGrowthModel(){
		return new GrowthModel(catterfly.getWingspan() / butterpillar.getLength(),
				catterfly.getWeight() / butterpillar.getLeavesEaten());
	}

	public Butterpillar getButterpillar() {
		return butterpillar;
	}

	public void setButterpillar(Butterpillar butterpillar) {
		this.butterpillar = butterpillar;
	}

	public Catterfly getCatterfly() {
		return catterfly;
	}

	public void setCatterfly(Catterfly catterfly) {
		this.catterfly = catterfly;
	}

	@Override
	public String toString() {
		return "Sample [butterpillar=" + butterpillar + ", catterfly=" + catterfly + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((butterpillar == null) ? 0 : butterpillar.hashCode());
		result = prime * result + ((catterfly == null) ? 0 : catterfly.hashCode());
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
		Sample other = (Sample) obj;
		if (butterpillar == null) {
			if (other.butterpillar != null)
				return false;
		} else if (!butterpillar.equals(other.butterpillar))
			return false;
		if (catterfly == null) {
			if (other.catterfly != null)
				return false;
		} else if (!catterfly.equals(other.catterfly))
			return false;
		return true;
	}
}
