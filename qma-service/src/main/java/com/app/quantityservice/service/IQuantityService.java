package com.app.quantityservice.service;

import com.app.quantityservice.dto.OperationResponse;
import com.app.quantityservice.dto.QuantityInputDTO;
import com.app.quantityservice.entity.QuantityOperation;

import java.util.List;

public interface IQuantityService {

    OperationResponse add(QuantityInputDTO input);

    OperationResponse subtract(QuantityInputDTO input);

    OperationResponse multiply(QuantityInputDTO input);

    OperationResponse divide(QuantityInputDTO input);

    OperationResponse compare(QuantityInputDTO input);

    OperationResponse convert(QuantityInputDTO input);

    List<QuantityOperation> getHistoryByOperation(String operation);

    List<QuantityOperation> getHistoryByType(String type);

    long countByOperation(String operation);
}
