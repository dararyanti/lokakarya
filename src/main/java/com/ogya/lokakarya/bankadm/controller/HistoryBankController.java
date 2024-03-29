package com.ogya.lokakarya.bankadm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ogya.lokakarya.bankadm.repository.HistoryBankRepository;
import com.ogya.lokakarya.bankadm.service.HistoryBankService;
import com.ogya.lokakarya.bankadm.wrapper.HistoryBankWrapper;
import com.ogya.lokakarya.util.DataResponse;
import com.ogya.lokakarya.util.DataResponseList;

@RestController
@RequestMapping(value = "/historybank")
@CrossOrigin()
public class HistoryBankController {
	@Autowired
	HistoryBankRepository historyBankRepository;
	@Autowired
	HistoryBankService historyBankService;
	
	@GetMapping(path = "/getByIdPlan")
	public HistoryBankWrapper getByidHistoryBank(@RequestParam("id") Long idHistoryBank) {
		return historyBankService.getByidHistoryBank(idHistoryBank);
	}
	
	@GetMapping(path = "/getById")
	public DataResponse<HistoryBankWrapper> getByidTransaksiNasabah(@RequestParam("id") Long idHistoryBank) {
		return new DataResponse<HistoryBankWrapper>(historyBankService.getByidHistoryBank(idHistoryBank));
	}
	
	@GetMapping(path = "/getByStatusKet")
	public DataResponseList<HistoryBankWrapper> getByStatusKetTransaksiNasabah(@RequestParam("statusKet") Byte statusKet) {
		return new DataResponseList<HistoryBankWrapper>(historyBankService.getBystatusKet(statusKet));
	}
	
	@GetMapping(path = "/sumStatus1")
	public Long sumStatus1() {
		return historyBankService.sumStatus1();
	}
	
	@GetMapping(path = "/sumStatus2")
	public Long sumStatus2() {
		return historyBankService.sumStatus2();
	}
	
	@GetMapping(path = "/sumStatus3")
	public Long sumStatus3() {
		return historyBankService.sumStatus3();
	}
	
	@GetMapping(path = "/sumStatus4")
	public Long sumStatus4() {
		return historyBankService.sumStatus4();
	}
	
	@GetMapping(path = "/findAllPlan")
	public List<HistoryBankWrapper> findAllPlan() {
		return historyBankService.findAll();
	}
	
	@GetMapping(path = "/findAll")
	public DataResponseList<HistoryBankWrapper> findAll() {
		return new DataResponseList<HistoryBankWrapper>(historyBankService.findAll());
	}
	
	@PostMapping(path = "/")
	public DataResponse<HistoryBankWrapper> save(@RequestBody HistoryBankWrapper wrapper){
		return new DataResponse<HistoryBankWrapper>(historyBankService.save(wrapper));
	}
	
	@PutMapping(path = "/")
	public DataResponse<HistoryBankWrapper> update(@RequestBody HistoryBankWrapper wrapper){
		return new DataResponse<HistoryBankWrapper>(historyBankService.save(wrapper));
	}
	
	@DeleteMapping(path = "/deleteById") 
	public String deleteId(@RequestParam("id")  Long norek) {
		historyBankService.delete(norek);
		return "History "+norek+" Berhasil di delete";
	}

}
