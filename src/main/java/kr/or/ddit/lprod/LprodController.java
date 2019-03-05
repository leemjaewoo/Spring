package kr.or.ddit.lprod;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.util.model.PageVO;

@RequestMapping("/lprod")
@Controller
public class LprodController {

	private Logger logger = LoggerFactory.getLogger(LprodController.class);

	
	@Resource(name = "lprodService")
	private ILprodService lprodService;
	
	
	
	@RequestMapping("/lprodAllList")
	public String userAllList(Model model) {

		  List<LprodVO> allLprod = lprodService.getAllLprod();

		model.addAttribute("allLprod", allLprod);

		return "lprod/lprodAllList";

	}


	
	
	@RequestMapping("/lprodpagingList")
	public String lprodpagingList(PageVO pageVo, Model model) {

				Map<String, Object> resultMap = lprodService.selectUserPagingList(pageVo);
				model.addAllAttributes(resultMap);

				model.addAttribute("pageSize", pageVo.getPageSize());
				model.addAttribute("page", pageVo.getPage());

				return "lprod/lprodPagingList";

	}
	
	
	
	@RequestMapping(path = "/lprod", method = RequestMethod.GET)
	public String user(@RequestParam("lprod") String lprod_gu, Model model) {

		List<ProdVO> selectLprod = lprodService.selectLprod(lprod_gu);
		model.addAttribute("selectLprod", selectLprod);

		return "lprod/lprod";
	}





















}
