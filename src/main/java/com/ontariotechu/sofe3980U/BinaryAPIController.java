package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.add(number1, number2).getValue();
	}

	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "add", number2, Binary.add(number1, number2));
	}

	@GetMapping("/binaryAPI")
	public String binaryAPI(
			@RequestParam(name="operand1") String operand1,
			@RequestParam(name="operand2") String operand2,
			@RequestParam(name="operator") String operator) {

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		Binary result;

		switch(operator) {
			case "+":
				result = Binary.add(number1, number2);
				break;
			case "*":
				result = Binary.multiply(number1, number2);
				break;
			case "|":
				result = Binary.or(number1, number2);
				break;
			default:
				return "Invalid Operator";
		}

		return result.getValue();
	}
}