package LeaveClass;

public class GetLeave {
	
	private String EmpID;
	private String Type;
	private String Start;
	private String End;
	private String Reason;
	
	
	public GetLeave(String EmpID, String Type, String Start, String End, String Reason) {
		
		setEmpID(EmpID);
		setType(Type);
		setStart(Start);
		setEnd(End);
		setReason(Reason);			
	}

	public String getEmpID() {
		return EmpID;
	}
	
	public void setEmpID(String EmpID) {
		this.EmpID=EmpID;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String Type) {
		this.Type=Type;
	}
	
	public String getStart() {
		return Start;
	}
	
    public void setStart(String Start) {
    	this.Start=Start;
    }
    
    public String getEnd() {
		return End;
	}
	
    public void setEnd(String End) {
    	this.End=End;
    }
    
    public String getReason() {
    	return Reason;
    }
    
    public void setReason(String Reason) {
    	this.Reason=Reason;
    }
   
}
