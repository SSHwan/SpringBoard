package com.seunghwan.springBoard.article.controller;

import com.seunghwan.springBoard.article.dto.ArticleDto;
import com.seunghwan.springBoard.article.service.ArticleService;
import com.seunghwan.springBoard.utility.page.Criteria;
import com.seunghwan.springBoard.utility.page.PageDto;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/article"})
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	private final ArticleService articleService;

	@Inject
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping({"/article"})
	public String list(Model model, Criteria criteria) throws Exception {
		logger.info("article list with page!");
		model.addAttribute("list", this.articleService.list(criteria));
		int total = this.articleService.getTotalArticle(criteria);
		model.addAttribute("pageMaker", new PageDto(criteria, total));
		return "article/article";
	}

	@RequestMapping({"/articleView"})
	public String viewArticle(int articleId, Model model, @ModelAttribute("criteria") Criteria criteria)
			throws Exception {
		logger.info("article view!");
		model.addAttribute("article", this.articleService.viewArticle(articleId));
		return "article/articleView";
	}

	@RequestMapping({"/articleWrite"})
	public String articleWrite() throws Exception {
		logger.info("articleWrite!");
		return "article/articleWrite";
	}

	@RequestMapping({"/createArticle"})
	public String createArticle(ArticleDto articleDto) throws Exception {
		logger.info("write article!");
		this.articleService.createArticle(articleDto);
		return "redirect:article";
	}

	@RequestMapping({"/delete"})
	public String deleteArticle(int articleId, Criteria criteria, RedirectAttributes redirect) throws Exception {
		logger.info("delete article!");
		this.articleService.deleteArticle(articleId);
		redirect.addAttribute("page", criteria.getPage());
		redirect.addAttribute("articlePerPage", criteria.getArticlePerPage());
		redirect.addAttribute("searchType", criteria.getSearchType());
		redirect.addAttribute("keyword", criteria.getKeyword());
		return "redirect:article";
	}

	@RequestMapping({"/modify"})
	public String modifyArticle(@ModelAttribute("article") ArticleDto articleDto,
			@ModelAttribute("criteria") Criteria criteria, Model model) throws Exception {
		logger.info("modify article viewPage!");
		return "article/articleModify";
	}

	@RequestMapping({"/modifyArticle"})
	public String modifyArticle(ArticleDto articleDto, Criteria criteria, RedirectAttributes redirect)
			throws Exception {
		logger.info("modify article!");
		this.articleService.modifyArticle(articleDto);
		redirect.addAttribute("articleId", articleDto.getArticleId());
		redirect.addAttribute("page", criteria.getPage());
		redirect.addAttribute("articlePerPage", criteria.getArticlePerPage());
		redirect.addAttribute("searchType", criteria.getSearchType());
		redirect.addAttribute("keyword", criteria.getKeyword());
		return "redirect:articleView";
	}

	@RequestMapping({"/reply"})
	public String reply(ArticleDto articleDto, @ModelAttribute("criteria") Criteria criteria, Model model)
			throws Exception {
		logger.info("reply viewPage!");
		model.addAttribute("article", articleDto);
		return "article/articleReply";
	}

	@RequestMapping({"/createReply"})
	public String createReply(ArticleDto articleDto, Criteria criteria, RedirectAttributes redirect) throws Exception {
		logger.info("article reply!");
		this.articleService.articleReply(articleDto);
		redirect.addAttribute("page", criteria.getPage());
		redirect.addAttribute("articlePerPage", criteria.getArticlePerPage());
		redirect.addAttribute("searchType", criteria.getSearchType());
		redirect.addAttribute("keyword", criteria.getKeyword());
		return "redirect:article";
	}
}