import React from 'react';
import { View as RNView, ViewProps } from 'react-native';

type PropTypes = ViewProps;

const View: React.FunctionComponent<PropTypes> = ({ children, ...props }) => (
  <RNView {...props}>{children}</RNView>
);

export default View;
