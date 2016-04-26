package java2.asm02;

public class BloodReservoir {
	private double costPerUnit;
	private int totalSoldUnits;
	
	public String extractInfo(){
		StringBuilder kq = new StringBuilder(200);
		kq.append("\nCost per unit: "+getCostPerUnit());
		kq.append("\nTotal sold units: "+getTotalUnits());
		kq.append("\nTotal income: "+getTotalIncome());
		return kq.toString();
	}
	
	public double getCostPerUnit() {
		return costPerUnit;
	}
	
	public void setCostPerUnit(double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	
	public int getTotalUnits() {
		return totalSoldUnits;
	}
	
	public void setTotalUnits(int totalUnits) {
		this.totalSoldUnits = totalUnits;
	}
	
	public void addTotalUnits(int units) {
		setTotalUnits(getTotalUnits()+units);
	}
	
	public double getTotalIncome(){
		return costPerUnit*totalSoldUnits;
	}
}
