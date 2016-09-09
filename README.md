# slick3-problems
Problems encountered upgrading to Slick 3.x from Slick 2.1

## Running

The problem I am facing is setup in `Problem.scala`

`sbt compile`

You should see the following error:

````
[error] /home/craiger/src/grind/slick-3-problem/src/main/scala/slick3/problem/Problem.scala:35: constructor cannot be instantiated to expected type;
[error]  found   : (T1, T2)
[error]  required: slick.lifted.Rep[Option[(slick3.problem.repo.model.UserContentTable, slick3.problem.repo.model.ContentTable)]]
[error]         .map { case (u, (uc, c)) => (u, c.optionProjection) }
[error]                         ^
[error] /home/craiger/src/grind/slick-3-problem/src/main/scala/slick3/problem/Problem.scala:35: diverging implicit expansion for type slick.lifted.Shape[_ <: slick.lifted.FlatShapeLevel, Nothing, T, G]
[error] starting with method repColumnShape in trait RepShapeImplicits
[error]         .map { case (u, (uc, c)) => (u, c.optionProjection) }
[error]              ^
[error] two errors found
````
