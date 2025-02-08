package com.puppycrawl.tools.checkstyle.xpath;


import com.puppycrawl.tools.checkstyle.api.DetailAST;

public class XpathQueryGeneratorProductProduct {
	private final int lineNumber;
	private final int columnNumber;
	private final int tokenType;

	public XpathQueryGeneratorProductProduct(int lineNumber, int columnNumber, int tokenType) {
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
		this.tokenType = tokenType;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	/**
	* Checks if the given   {@code   DetailAST}   node is matching line number, column number and token type.
	* @param ast     {@code   DetailAST}   ast element
	* @return   true if the given   {@code   DetailAST}   node is matching
	*/
	public boolean isMatchingByLineAndColumnAndTokenType(DetailAST ast,
			XpathQueryGeneratorProduct xpathQueryGeneratorProduct) {
		return ast.getLineNo() == lineNumber && xpathQueryGeneratorProduct.expandedTabColumn(ast) == columnNumber
				&& (tokenType == 0 || tokenType == ast.getType());
	}
}