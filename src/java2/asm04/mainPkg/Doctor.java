package java2.asm04.mainPkg;

import java2.asm04.utilPkg.ValUtils;

public class Doctor extends ValUtils {
	private String code, name, spec;
	private int hours;
	
	public Doctor(String code, String name, String spec, int hours) throws Exception {
		setCode(code);
		setName(name);
		setSpec(spec);
		setHours(hours);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) throws Exception {
		code = code.trim().toUpperCase();
		valFormat(code, "DO\\d{3}", "Doctor code format is DOxxx");
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		name = name.trim();
		valFormat(name, "[\\p{L} ]{3,20}", "Name is 3-20 normal characters!");
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) throws Exception {
		spec = spec.trim();
		valFormat(spec, "[\\p{L} ]{3,20}", "Specialization is 3-20 normal characters!");
		this.spec = spec;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) throws Exception {
		valRangedValue(hours, 1, "Valid hours is from 1.");
		this.hours = hours;
	}
	
	@Override
	public String toString() {
		StringBuilder kq = new StringBuilder(100);
		kq.append("Doctor [code: "+getCode());
		kq.append(",  name: "+getName());
		kq.append(", spec: "+getSpec());
		kq.append(", hours: "+getHours());
		kq.append("].");
		return kq.toString();
	}
}
