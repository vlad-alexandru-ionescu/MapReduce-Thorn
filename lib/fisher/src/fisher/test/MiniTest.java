/** 
 * Copyright (c) 2009 IBM Corp. 
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html. If redistributing this code, 
 * this entire header must remain intact. 
 */
package fisher.test;

import java.io.File;

import fisher.runtime.ThingExtended;
import fisher.syn.AnonObj;
import fisher.syn.ClsDecl;
import fisher.syn.MethDecl;
import fisher.util.Bard;
import junit.framework.TestCase;
import static fisher.syn.core.Op.AND;
import static fisher.syn.core.Op.PLUS;
import static fisher.test.EvalTest.*;
import static fisher.test.DistTest.*;
import static fisher.test.PurityTest.*;

import static fisher.parser.SyntacticClass.*;

public class MiniTest extends TestCase {
	static String copyright() {
		return fisher.util.Copyright.IBM_COPYRIGHT;
	}
	public void test028() throws Exception {
		distTest("028-obj");
	}
	public void test073_security() throws Exception {
		String dir = "073-security";
		String modules = Bard.contentsOf(TestUtils.testfile("eval/" + dir + "/Modules.thm"));
		evalFiles("073", dir, modules);
	}
	public void test048() throws Exception {
		distTest("048-security-1");
	}
}
