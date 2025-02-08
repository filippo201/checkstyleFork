package com.puppycrawl.tools.checkstyle.checks.indentation;


import java.util.SortedMap;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import java.util.TreeMap;

public class DetailAstSetProduct {private final SortedMap<Integer, DetailAST> astLines=new TreeMap<>();/**
 * Map ast with their line number.
 * @param lineNo     line number of ast to add
 * @param ast        ast to add
 */public void addLineWithAst(int lineNo,DetailAST ast){astLines.put(lineNo,ast);}/**
 * Check if this set of ast is empty.
 * @return  true if empty, false otherwise
 */public boolean isEmpty(){return astLines.isEmpty();}/**
 * The first line in set of ast.
 * @return  first line in set of ast.
 */public DetailAST firstLine(){return astLines.get(astLines.firstKey());}/**
 * Get the ast corresponding to line number.
 * @param lineNum    line number of ast.
 * @return           ast with their corresponding line number or null if no mapping is present
 */public DetailAST getAst(int lineNum){return astLines.get(lineNum);}/**
 * Get the line number of the last line.
 * @return  the line number of the last line
 */public Integer lastLine(){return astLines.lastKey();}}