////////////////////////		File History			//////////////////
//------------------------------------------------------------------------
//Date		User			Description
//------	-----------		----------------------------------------------
//150420	IT16109254		:Created
//150420	IT16109254		:Added attributes
//////////////////////////////////////////////////////////////////////////
package com.payment;

import java.sql.Date;

public class Payment {

	////////////region Private attributes/////
	private 	int		refNumber	;
	private 	Date 	date		;
	private		float	amount		;
	////////////endregion/////////////////////
	
	///////////	region	getters setters	///////
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(int refNumber) {
		this.refNumber = refNumber;
	}
	/////////////endregion///////////////////////
	
}
