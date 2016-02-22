package lu.uni.adtool.domains.adtpredefined;

import lu.uni.adtool.domains.AdtDomain;
import lu.uni.adtool.domains.rings.RealG0;
import lu.uni.adtool.tools.Options;
import lu.uni.adtool.tree.ADTNode;
import lu.uni.adtool.tree.Node;

/**
 * A AtdDomain defined on booleans.
 *
 * @author Piot Kordy
 */
public class MinTimePar extends RankingDomain<RealG0> {
  // number 5

  /**
   * Constructs a new instance.
   */
  public MinTimePar() {
  }

  public boolean isOrType(ADTNode.Type operation) {
    switch (operation) {
    case AND_OPP:
    case OR_PRO:
      return true;
    case OR_OPP:
    case AND_PRO:
    default:
      return false;
    }
  }

  public RealG0 calc(RealG0 a, RealG0 b, ADTNode.Type type) {
    switch (type) {
    case OR_OPP:
      return RealG0.max(a, b);
    case AND_OPP:
      return RealG0.min(a, b);
    case OR_PRO:
      return RealG0.min(a, b);
    case AND_PRO:
      return RealG0.max(a, b);
    default:
      return RealG0.max(a, b);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @see AdtDomain#cp(RealG0,RealG0)
   */
  public final RealG0 cp(final RealG0 a, final RealG0 b) {
    return RealG0.max(a, b);
  }

  /**
   * {@inheritDoc}
   *
   * @see AdtDomain#co(RealG0,RealG0)
   */
  public final RealG0 co(final RealG0 a, final RealG0 b) {
    return RealG0.min(a, b);
  }

  /**
   * {@inheritDoc}
   *
   * @see AdtDomain#getDefaultValue()
   */
  public final RealG0 getDefaultValue(Node node) {
    if (((ADTNode) node).getRole() == ADTNode.Role.PROPONENT) {
      return new RealG0(Double.POSITIVE_INFINITY);
    }
    else {
      return new RealG0(Double.POSITIVE_INFINITY);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @see AdtDomain#isValueModifiable(boolean)
   */
  public final boolean isValueModifiable(ADTNode node) {
    return  node.getRole() == ADTNode.Role.PROPONENT;
  }

  /**
   * {@inheritDoc}
   *
   * @see AdtDomain#getName()
   */
  public String getName() {
    return Options.getMsg("adtdomain.mintimepar.name");
  }

  /**
   * {@inheritDoc}
   *
   * @see AdtDomain#getDescription()
   */
  public String getDescription() {
    final String name = Options.getMsg("adtdomain.mintimepar.description");
    final String vd = "&#x211D;\u208A\u222A{\u221E}";
    final String[] operators =
        {"min(<i>x</i>,<i>y</i>)", "max(<i>x</i>,<i>y</i>)", "max(<i>x</i>,<i>y</i>)",
            "min(<i>x</i>,<i>y</i>)", "max(<i>x</i>,<i>y</i>)", "min(<i>x</i>,<i>y</i>)",};
    return DescriptionGenerator.generateDescription(this, name, vd, operators);
  }


  static final long serialVersionUID = 565945232556446855L;
}
