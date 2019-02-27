package kr.or.ddit.ranger.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.ranger.dao.IRangerDao;

@Service("rangerService")
public class RangerServiceImpl implements IRangerService {
	
	@Resource(name="rangerDao")
	private IRangerDao rangerDao;
	
	public RangerServiceImpl(){
		
	}

	public RangerServiceImpl(IRangerDao rangerDao) {
		this.rangerDao = rangerDao;
	}



	@Override
	public List<String> getRangers() {
		return rangerDao.getRangers();
		
	}

	public void setRangerDao(IRangerDao rangerDao) {
		this.rangerDao = rangerDao;
	}

	@Override
	public IRangerDao getRangerDao() {
		return this.rangerDao;
	}

	@Override
	public String getRanger(int index) {
		// TODO Auto-generated method stub
		return rangerDao.getRanger(index);
	}
	
	

}
