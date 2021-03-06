package se.uu.it.cs.recsys.constraint.constraints;

/*
 * #%L
 * CourseRecommenderConstraintSolver
 * %%
 * Copyright (C) 2015 Yong Huang  <yong.e.huang@gmail.com >
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.Map;
import java.util.Set;
import org.jacop.core.Store;
import org.jacop.set.constraints.EinA;
import org.jacop.set.core.SetVar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Yong Huang &lt;yong.e.huang@gmail.com>&gt;
 */
public class FixedCourseSelectionConstraint {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedCourseSelectionConstraint.class);

    public static void impose(Store store,
            SetVar[] periodVars,
            Map<Integer, Set<Integer>> periodNumAndFixedIdSet) {

        LOGGER.debug("Posting constraints on fixed selection!");

        periodNumAndFixedIdSet.entrySet().forEach(
                (Map.Entry<Integer, Set<Integer>> entry) -> {

                    SetVar periodVar = periodVars[entry.getKey() - 1];

                    entry.getValue().forEach(
                            (Integer courseId) -> {
                                EinA elemInSetConst = new EinA(courseId, periodVar);
                                store.impose(elemInSetConst);
                            });
                });
    }

}
