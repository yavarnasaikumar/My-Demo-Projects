package reservationSystem.passengers;

public class Passenger {
	
	private Integer seatNo;
	private String pnrNo, name, email, boardingPoint,dropingPoint;
	private int age;
	
	public Passenger(Integer seatNo, String pnrNo, String name, String email, String boardingPoint, String dropingPoint, int age) {
		super();
		this.seatNo = seatNo;
		this.pnrNo = pnrNo;
		this.name = name;
		this.email = email;
		this.boardingPoint = boardingPoint;
		this.dropingPoint = dropingPoint;
		this.age = age;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDropingPoint() {
		return dropingPoint;
	}

	public void setDropingPoint(String dropingPoint) {
		this.dropingPoint = dropingPoint;
	}

	@Override
	public String toString() {
		return "Passenger [seatNo=" + seatNo + ", pnrNo=" + pnrNo + ", name=" + name + ", email=" + email
				+ ", boardingPoint=" + boardingPoint + ", dropingPoint=" + dropingPoint + ", age=" + age + "]";
	}
}
