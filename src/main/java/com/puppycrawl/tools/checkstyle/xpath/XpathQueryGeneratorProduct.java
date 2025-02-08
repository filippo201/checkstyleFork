package com.puppycrawl.tools.checkstyle.xpath;


import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;

public class XpathQueryGeneratorProduct {
	private XpathQueryGeneratorProductProduct xpathQueryGeneratorProductProduct;
	private final FileText fileText;
	private final int tabWidth;

	public XpathQueryGeneratorProduct(int lineNumber, int columnNumber, int tokenType, FileText fileText,
			int tabWidth) {
		this.xpathQueryGeneratorProductProduct = new XpathQueryGeneratorProductProduct(lineNumber, columnNumber,
						tokenType);
		this.fileText = fileText;
		this.tabWidth = tabWidth;
	}

	/**
	* Checks if the given  {@code  DetailAST}  node is matching line number, column number and token type.
	* @param ast   {@code  DetailAST}  ast element
	* @return  true if the given  {@code  DetailAST}  node is matching
	*/
	public boolean isMatchingByLineAndColumnAndTokenType(DetailAST ast) {
		return xpathQueryGeneratorProductProduct.isMatchingByLineAndColumnAndTokenType(ast, this);
	}

	/**
	* Returns the column number with tabs expanded.
	* @param ast   {@code  DetailAST}  root ast
	* @return  the column number with tabs expanded
	*/
	public int expandedTabColumn(DetailAST ast) {
		return 1 + CommonUtil.lengthExpandedTabs(fileText.get(xpathQueryGeneratorProductProduct.getLineNumber() - 1), ast.getColumnNo(), tabWidth);
	}
}