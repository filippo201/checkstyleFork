///////////////////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code and other text files for adherence to a set of rules.
// Copyright (C) 2001-2025 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
///////////////////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle.checks.indentation;

import java.util.SortedMap;
import java.util.TreeMap;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;

/**
 * Represents a set of abstract syntax tree.
 *
 */
public class DetailAstSet {

    private DetailAstSetProduct detailAstSetProduct = new DetailAstSetProduct();

	/**
     * The instance of {@code IndentationCheck} used by this class.
     */
    private final IndentationCheck indentCheck;

    /**
     * Construct an instance of this class with {@code IndentationCheck} parameters.
     *
     * @param indentCheck IndentationCheck parameters
     */
    public DetailAstSet(IndentationCheck indentCheck) {
        this.indentCheck = indentCheck;
    }

    /**
     * Add ast to the set of ast.
     *
     * @param ast   the ast to add
     */
    public void addAst(DetailAST ast) {
        detailAstSetProduct.addLineWithAst(ast.getLineNo(), ast);
    }

    /**
     * Get starting column number for the ast.
     *
     * @param lineNum the line number as key
     * @return start column for ast
     */
    public Integer getStartColumn(int lineNum) {
        Integer startColumn = null;
        final DetailAST ast = detailAstSetProduct.getAst(lineNum);

        if (ast != null) {
            startColumn = expandedTabsColumnNo(ast);
        }

        return startColumn;
    }

    /**
     * Check if this set of ast is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return detailAstSetProduct.isEmpty();
    }

    /**
     * The first line in set of ast.
     *
     * @return first line in set of ast.
     */
    public DetailAST firstLine() {
        return detailAstSetProduct.firstLine();
    }

    /**
     * Get the ast corresponding to line number.
     *
     * @param lineNum   line number of ast.
     * @return          ast with their corresponding line number or null if no mapping is present
     */
    public DetailAST getAst(int lineNum) {
        return detailAstSetProduct.getAst(lineNum);
    }

    /**
     * Get the line number of the last line.
     *
     * @return the line number of the last line
     */
    public Integer lastLine() {
        return detailAstSetProduct.lastLine();
    }

    /**
     * Get the column number for the start of a given expression, expanding
     * tabs out into spaces in the process.
     *
     * @param ast   the expression to find the start of
     *
     * @return the column number for the start of the expression
     */
    protected final int expandedTabsColumnNo(DetailAST ast) {
        final String line =
            indentCheck.getLine(ast.getLineNo() - 1);

        return CommonUtil.lengthExpandedTabs(line, ast.getColumnNo(),
            indentCheck.getIndentationTabWidth());
    }

}
