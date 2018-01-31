package com.practise.util;

import com.practise.service.IProvisioningResponse;
import com.tc.tsp.dcm.models.v1.Message;
import com.tc.tsp.dcm.models.v1.MsgType;
import com.tc.tsp.dcm.models.v1.OperationType;
import com.tc.tsp.dcm.models.v1.ServiceType;
import com.tc.tsp.dcm.models.v1.TransmissionTimestamp;

/**
 * Creates the Provisioning Response for invalid Information for DCM.
 */
public class ProvisioningResponse implements IProvisioningResponse {

	private Message message;
	private TransmissionTimestamp transmissionTimestamp;

	public ProvisioningResponse(MsgType msgType) {
		message = new Message();
		message.setType(msgType);
		message.setService(ServiceType.PROVISIONING);
		message.setOperation(OperationType.PROVISIONING);

		transmissionTimestamp = new TransmissionTimestamp();
		transmissionTimestamp.setDatetime(DateTimeTypeBuilder.getCurrentDateTime());
	}

	@Override
	public MsgType getMessageType() {
		return message.getType();
	}

}
