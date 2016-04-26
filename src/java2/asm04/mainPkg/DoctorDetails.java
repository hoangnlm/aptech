package java2.asm04.mainPkg;

import java.util.HashMap;

public class DoctorDetails {
	private HashMap<String, Doctor> doctorHashMap;

	public DoctorDetails() {
		doctorHashMap = new HashMap<>(10);
	}

	public HashMap<String, Doctor> getDoctorHashMap() {
		return doctorHashMap;
	}

	public void addDoctor(Doctor doctor) {
		getDoctorHashMap().put(doctor.getCode(), doctor);
	}

	public Doctor searchDoctor(String code) {
		code = code.trim().toUpperCase();
		
		for(Doctor m:getDoctorHashMap().values())
			if(m.getCode().equals(code))
				return m;
		
		return null;
	}

	@Override
	public String toString() {
		StringBuilder kq = new StringBuilder(200);
		
		for(Doctor m:getDoctorHashMap().values())
			kq.append(m.toString()+"\n");
		
		return kq.toString();
	}
}
